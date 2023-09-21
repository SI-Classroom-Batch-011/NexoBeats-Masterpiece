<div align="center">
<h1>NexoBeats - Masterpiece</h1>
<h4>Menu</h4>


<button onclick="toggleIdee()" style="background-color: #000f26; color: #fff; border: none; border-radius: 5px; padding: 10px 20px; font-size: 16px;">• Die Idee •</button> 
&emsp; [<kbd><br>• Erste Schritte •<br><br></kbd>][Link2] 
&emsp; [<kbd><br>• Types •<br><br></kbd>][Link3] 
&emsp; [<kbd><br>• Credits •<br><br></kbd>][Link4]

</div>

_<h6 align="center">Das ist das Abschlussprojekt von <u>Nico-Tobias Merzky</u> im Modul 2 von Batch 11.</h6>_

<table id="dieIdee" style="display: none;">
<tr>
<th>Wie komme ich auf eine schlüssige Idee?</th>
</tr>
<tr>
<td>

- <font color="orange">Social Media
- Spiele
- Videos
- Musik
- Filme
- Serien
  </font>

</td>
</tr>
<tr>
<td><h6><i>Es gibt eine Menge Möglichkeiten eine Idee zu finden und sich daran zu orientieren.</i></h6></td>
</tr>
</table>

<script>
function toggleIdee() {
    var table = document.getElementById("dieIdee")
    if (table.style.display === "none") {
        table.style.display = "table";
    } else {
        table.style.display = "none";
    }
}
</script>

[Link2]: ersteSchritte.md 'Hier sind die ersten Schritte Dokumentiert wie ich mein Projekt angefangen habe.'
[Link3]: img/pokemontypeimg.jpg 'Hier findest du die Pokemon typen und deren Stärken, Schwächen und Ineffektivitäten.'
[Link4]: contributors.md 'Hier kannst du alle finden die an dem Projekt beteiligt waren.'