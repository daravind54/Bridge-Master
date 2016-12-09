<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="temp.js"></script>
</head>
<body>
<div id="welcome">
	<h1>Login successful</h1>
</div>
<div id="username">
	<h3>Welcome, <%= session.getAttribute("username") %></h3>
	<form action="logout" method="post">
	<input type="submit" name="logout" id="logout" value="Logout">
	</form>

</div>

<form id="form1">


<input type="button"  value="Join Game" onclick=formSubmit()>
<a href="">View Stats</a><br>
</form>
<br>
<div id="waiting">
	<h2>Waiting for other players to join...</h2>
</div>
<div id="cards">
	You are Player <input type="text" name="playerName" id="playerName" readonly><br>
	In <input type="text" id="gameType" name="gameType" readonly><br>
	Its <input type="text" id="turn" name="turn" readonly> turn
	<br><br>
	<table>
		<tr>
				<td></td>
				<td></td>
				<td>
					<form id="userInput">
						<input type="text" id="Ninput" name="Ninput">
						<input type="button"  id="NSubmitBid" value="SubmitBid" onclick=formSubmitBidN()>
						<input type="button"  id="NSubmitCard" value="SubmitCard" onclick=formSubmitCardN()>
					</form><br>
					
					<label for="tricksWonN" id="tricksWonNLabel">Tricks Won:</label>
					<input type="text" id="tricksWonN" name="tricksWonN" readonly><br>
					<input type="text" id="playedValueN" name="playedValueN" readonly>
					
				</td>
				<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td id="North">
			Clubs:<input type="text" id="Nclubs" name="Nclubs" readonly>
			<br>
			Diamonds:<input type="text" id="Ndiamonds" name="Ndiamonds" readonly>
			<br>
			Hearts:<input type="text" id="Nhearts" name="Nhearts" readonly>
			<br>
			Spades:<input type="text" id="Nspades" name="Nspades" readonly>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>
				<form id="userInput">
						<input type="text" id="Winput" name="Winput">
						<input type="button"  id="WSubmitBid" value="SubmitBid" onclick=formSubmitBidW()>
						<input type="button"  id="WSubmitCard" value="SubmitCard" onclick=formSubmitCardW()>
						
					</form><br>
					<input type="text" id="playedValueW" name="playedValueN" readonly><br>
					<label for="tricksWonW" id="tricksWonWLabel">Tricks Won:</label>
					<input type="text" id="tricksWonW" name="tricksWonW" readonly>
			</td>
			<td id="West">
			Clubs:<input type="text" id="Wclubs" name="Wclubs" readonly>
			<br>
			Diamonds:<input type="text" id="Wdiamonds" name="Wdiamonds" readonly>
			<br>
			Hearts:<input type="text" id="Whearts" name="Whearts" readonly>
			<br>
			Spades:<input type="text" id="Wspades" name="Wspades" readonly>
			</td>
			<td></td>
			<td id="East">
			Clubs:<input type="text" id="Eclubs" name="Eclubs" readonly>
			<br>
			Diamonds:<input type="text" id="Ediamonds" name="Ediamonds" readonly>
			<br>
			Hearts:<input type="text" id="Ehearts" name="Ehearts" readonly>
			<br>
			Spades:<input type="text" id="Espades" name="Espades" readonly>
			</td>
			<td>
				<form id="userInput">
						<input type="text" id="Einput" name="Einput">
						<input type="button"  id="ESubmitBid" value="SubmitBid" onclick=formSubmitBidE()>
						<input type="button"  id="ESubmitCard" value="SubmitCard" onclick=formSubmitCardE()>
						
				</form><br>
				<input type="text" id="playedValueE" name="playedValueN" readonly><br>
					<label for="tricksWonE" id="tricksWonELabel">Tricks Won:</label>
					<input type="text" id="tricksWonE" name="tricksWonE"  readonly>
			</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td id="South">
			Clubs:<input type="text" id="Sclubs" name="Sclubs" readonly>
			<br>
			Diamonds:<input type="text" id="Sdiamonds" name="Sdiamonds" readonly>
			<br>
			Hearts:<input type="text" id="Shearts" name="Shearts" readonly>
			<br>
			Spades:<input type="text" id="Sspades" name="Sspades" readonly>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td>
				<form id="userInput">
						<input type="text" id="Sinput" name="Sinput">
						<input type="button"  id="SSubmitBid" value="SubmitBid" onclick=formSubmitBidS()>
						<input type="button"  id="SSubmitCard" value="SubmitCard" onclick=formSubmitCardS()>
						
					</form><br>
					<input type="text" id="playedValueS" name="playedValueN" readonly><br>
					<label for="tricksWonS" id="tricksWonSLabel">Tricks Won:</label>
					<input type="text" id="tricksWonS" name="tricksWonS" readonly>
			</td>
			<td></td>
		</tr>
	</table>
</div>
<div id="gameRules">
<h3>Game Rules</h3>
<ul>
	<li>Bidding rules</li>
	<ol>
		<li>After looking at the cards in your hand. Make a call, call can be either a bid or a pass.</li>
		<li>Bid should be of the format a number from one to seven followed by a suit. The number is the tricks in addition to six that the bidder agrees to win. The suit is the suit that will be trumps or notrump if the bidder wishes to play without a trump suit.</li>
		<li>Example of a Bid is "1 H", which means that the bidder is agreeing to win a total of 7 (6+1) tricks and the game will be played with Hearts as trump suit.</li>
		<li>Each successive  bid should be higher numbered than the preceding bid or can be a equal numbered from a higher ranked suit. 
			In Bidding phase, the suits are ranked as follows:
			<ol>
				<li>notrump </li>
				<li>spades</li>
				<li>Hearts</li>
				<li>Diamonds</li>
				<li>Clubs</li>
			</ol> 
		</li>
		<li>For example: if the opening bid is one spade, the next bid by any player may be one notrump or two or more in any suit or notrump.</li>
		<li>Bidding ends when 3 players consecutively pass.</li>
	</ol>
	<li>Play Rules</li>
	<ol>
		<li>Play consists of entering/placing a card in your hand.</li>
		<li>First card played is the lead card and remaining players should follow the suit of lead.</li>
		<li>Card input should be of the following format, suit followed by number. For example "S 5" means 5 of spades.</li>
		<li>Once all the players have played their card, the trick is complete and the player card with the highest rank wins the trick.</li>
	</ol>
</ul>
</div>
</body>
</html>