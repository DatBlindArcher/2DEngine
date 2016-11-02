package multiplayer.game;

import com.codedisaster.steamworks.SteamID;

public class SteamLobby 
{
	public SteamID ID;
	public String name;
	public SteamPlayer host;
	public SteamPlayer[] players;
	
	public SteamLobby(SteamID id)
	{
		update(id);
	}
	
	public void update(SteamID id)
	{
		ID = id;
		name = SteamManager.instance.matchmaking.getLobbyData(ID, "Name");
		host = new SteamPlayer(SteamManager.instance.matchmaking.getLobbyOwner(ID));
		players = new SteamPlayer[SteamManager.instance.matchmaking.getNumLobbyMembers(ID)];
		
		for(int i = 0; i < players.length; i++)
		{
			players[i] = new SteamPlayer(SteamManager.instance.matchmaking.getLobbyMemberByIndex(ID, i));
		}
	}
}