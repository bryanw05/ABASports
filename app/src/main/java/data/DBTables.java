package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class DBTables extends AsyncTask<Integer, Void, ArrayList<Player>> {

	private int request;
	private static String URL_SOURCE = "http://abasports.org/android/";

	public DBTables(int r) {
		request = r;
	}

	@Override
	protected ArrayList<Player> doInBackground(Integer... IDs) {
		try {
			if (request == 0) // players table
				setEmptyPlayerInfo();
			else if (request == 1) { // teams table
				setTeamInfo();
				setGamesInfo();
			} else if (request == 2) // games table
				setGamesInfo();
			else if (request == 3) {
				ArrayList<Player> single = new ArrayList<Player>();
				single.add(getLoadedPlayer(IDs[0]));
				return single;
			} else if (request == 4)
				return getLeaders();

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static JSONArray streamJsonArray(String table, String sourceUrl)
			throws IOException, JSONException {

		// DefaultHttpClient client = new DefaultHttpClient();
		// HttpGet httpGet = new HttpGet(sourceUrl);
		// HttpResponse hr = client.execute(httpGet);
		// is = hr.getEntity().getContent();
		URL url = new URL(sourceUrl);
		InputStream is = url.openStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(is,
				"UTF-8"));

		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null)
			sb.append(line);

		is.close(); // close the InputStream;

		JSONObject obj = new JSONObject(sb.toString());

		// possible codes are -2(DB open error(severe)),
		// -1(DB query error), 0(empty table), #>0(no error =).
		// Applies to all tables/query results
		if (obj.getInt("result") > 0)
			return obj.getJSONArray(table);

		return null;
	}

	public static void setGamesInfo() throws IOException, JSONException {
		GameInfo games = GameInfo.getInstance();
		TeamInfo teams = TeamInfo.getInstance();
		String url = URL_SOURCE + "jsongames.php"; // to view the JSON string
													// output at this url, hold
													// ctrl and click on this
													// string
		JSONArray gArray = streamJsonArray("games", url);

		if (games.getData().isEmpty() && gArray != null) {
			for (int i = 0; i < gArray.length(); i++) {
				JSONObject obj = gArray.getJSONObject(i);

				String location = obj.getString("location");
				Team A = teams.getTeam(obj.getString("team1"));
				Team B = teams.getTeam(obj.getString("team2"));

				games.addGame(new Game(A, B, location, parseGameInfo(obj.getString("date"), obj.getString("time")), obj.getString("time")));
			}
		}
	}

	public static Calendar parseGameInfo(String date, String time) {
		Scanner parseString = new Scanner(date + " " + time);
		parseString.useDelimiter("-");
		int month = parseString.nextInt();
		month = (month == 0) ? month : month - 1;
		int day = parseString.nextInt();
		parseString.reset();
		int year = Integer.valueOf(parseString.next().substring(1));
		parseString.useDelimiter(":");
		int gameHour = Integer.valueOf(parseString.next().substring(1));
		int gameMinute = Integer.valueOf(parseString.next());
		parseString.close();

		Calendar d = Calendar.getInstance();
		d.set(Calendar.MONTH, month);
		d.set(Calendar.DAY_OF_MONTH, day);
		d.set(Calendar.YEAR, year);
		d.set(Calendar.HOUR_OF_DAY, gameHour);
		d.set(Calendar.MINUTE, gameMinute);

		return d;
	}

	public static void setEmptyPlayerInfo() throws IOException, JSONException {
		EmptyPlayerInfo players = EmptyPlayerInfo.getInstance();
		String url = URL_SOURCE + "jsonplayers.php";

		// jsonplayers.php queries only first and last names of all players
		// to view the json string output at this url, hold ctrl and click on
		// this string

		JSONArray pArray = streamJsonArray("players", url);

		if (players.getData().isEmpty() && pArray != null) {
			for (int i = 0; i < pArray.length(); i++) {
				EmptyPlayer ep = emptyPlayer(pArray.getJSONObject(i)); // dont
																		// fill
																		// up
																		// player
																		// objects
																		// until
																		// they
																		// click
																		// on a
																		// player
																		// profile
				players.addEmptyPlayer(ep);
			}
		}
	}

	private static EmptyPlayer emptyPlayer(JSONObject p) throws JSONException {

		// PlayerInfo uses this to create players with low overhead, since they
		// don't need all stats.
		// the idea is to load the application fast on start up, by streaming
		// less data from the DB on a separate thread

		EmptyPlayer ep = new EmptyPlayer();
		ep.setFirstName(p.getString("first_name"));
		ep.setLastName(p.getString("last_name"));
		ep.setTeam(p.getString("team"));
		ep.setID(p.getInt("ID"));

		return ep;
	}

	private static ArrayList<Player> getLeaders() throws IOException,
			JSONException {
		String url = URL_SOURCE + "getleaders.php";
		JSONArray leadersArray = streamJsonArray("players", url);
		ArrayList<Player> leaders = new ArrayList<Player>();

		if (leadersArray != null) {
			for (int i = 0; i < leadersArray.length(); i++) {
				JSONObject obj = leadersArray.getJSONObject(i);
				Player p = loadedPlayer(obj);
				leaders.add(p);
			}
		}
		return leaders;
	}

	private static Player loadedPlayer(JSONObject jp) throws JSONException {
		Player p = new Player();

		p.setID(jp.getInt("ID"));
		p.setFirstName(jp.getString("first_name"));
		p.setLastName(jp.getString("last_name"));
		p.setNumber(jp.getInt("number"));
		p.setPosition(jp.getString("position"));
		p.setTeam(jp.getString("team"));
		p.setPoints(jp.getInt("points"));
		p.setDunks(jp.getInt("dunks"));
		p.setAssists(jp.getInt("assists"));
		p.setSteals(jp.getInt("steals"));
		p.setRebounds(jp.getInt("rebounds"));
		p.setFouls(jp.getInt("fouls"));
		p.setBlocks(jp.getInt("blocks"));
		p.setGoalTends(jp.getInt("goal_tends"));

		return p;
	}

	private static Player getLoadedPlayer(int id) throws IOException,
			JSONException {
		String url = URL_SOURCE + "getrequest.php?ID=" + id;
		JSONArray singlePlayer = streamJsonArray("players", url);
		JSONObject jp = singlePlayer.getJSONObject(0);

		return loadedPlayer(jp);
	}

	public static void setTeamInfo() throws IOException, JSONException {
		TeamInfo teams = TeamInfo.getInstance();
		String urlsource = URL_SOURCE + "jsonteams.php"; // to view the json
															// string output at
															// this url, hold
															// ctrl and click on
															// this string
		JSONArray tArray = streamJsonArray("teams", urlsource);

		if (teams.getData().isEmpty() && tArray != null) {
			for (int i = 0; i < tArray.length(); i++) {
				Team T = jsonToTeam(tArray.getJSONObject(i));
				teams.addTeam(T);
			}
		}
	}

	public static Team jsonToTeam(JSONObject jt) throws JSONException,
			IOException {
		Team t = new Team();
		t.setName(jt.getString("name"));
		t.setDivision(jt.getString("division"));
		t.setWins(jt.getInt("wins"));
		t.setLosses(jt.getInt("losses"));
		t.setAway(jt.getInt("away"));
		t.setWinPercentage(t.calcPercentage());
		t.setHome(jt.getInt("home"));
		t.setPfor(jt.getInt("points_for"));
		t.setPagainst(jt.getInt("points_against"));
		t.setLast10(jt.getString("last_10"));
		t.setStreak(jt.getString("current_streak"));

		ArrayList<EmptyPlayer> roster = EmptyPlayerInfo.getTeam(t.getName());
		t.setPlayers(roster);

		return t;
	}

	// private static Team jsonToTeam (String teamName) throws IOException,
	// JSONException{
	// String url = URL_SOURCE + "getrequest.php";
	// String query = "query=select-*-from-teams-where-name-='" + teamName +
	// "'"; // %27 corresponds to single quote in url encoding: '
	// String encodedQuery = URLEncoder.encode(query, "utf-8");
	// String urlQuery = url + "?" + encodedQuery;
	//
	// JSONArray singleTeam = streamJsonArray("teams", urlQuery);
	// return jsonToTeam(singleTeam.getJSONObject(0));
	// }

}
