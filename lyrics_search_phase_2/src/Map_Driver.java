import java.util.*;
public class Map_Driver{
  public static void main(String[] args){
    //given lyrics, song, and album
    String album1 = "The Life of Pablo";
    String song1 = "Father Stretch My Hands";
    String lyrics1 = "You're the only power You're the only power that can You're the only power You're the only power that can ohhhh If young Metro don't trust you I'm gon' shoot you Beautiful morning you're the sun in my morning babe Nothing unwanted Beautiful morning you're the sun in my morning babe Nothing unwanted Just want to feel liberated I I I I just want to feel liberated I I I If I ever instigated I��m sorry Tell me who in here can relate I I I Now if I fuck this model And she just bleached her asshole And I get bleach on my T-shirt I'mma feel like an asshole I was high when I met her We was down in Tribeca She get under your skin if you let her She get under your skin if you-uh I don't even want to talk about it I don't even want to talk about it I don't even want to say nothing Everybody gon' say something I'd be worried if they said nothing Remind me where I know you from? She looking like she owe you some You know just what we want I want to wake up with you in my eyes Beautiful morning you're the sun in my morning babe Nothing unwanted Beautiful morning you're the sun in my morning babe Nothing unwanted Just want to feel liberated I I I I just want to feel liberated I I I If I ever instigated Im sorry Tell me who in here can relate I I I~";

    String album2 = "Late Registration";
    String song2 = "Drive Slow";
    String lyrics2 = "Drive slow homie drive slow homie You never know homie might meet some hoes homie You need to pump your brakes and drive slow homie My homie Marley used to stay 79th and May One of my best friends from back in the day Down the street from Calumet a school full of stones He nicknamed me K-Rock so they'd leave me alone Bulls jacket with his hat broke way off And walked around the mall with his radio face off Plus he had the spinner from his Daytons in his hand Keys in his hand reason again to let you know he's the man Back when we rocked Ellesses he had dreams of Caprices Drove by the teachers even more by polices How'd he get the cash? The day his father passed away Left him with a lil' somethin' sixteen he was stuntin' Al B. Sure nigga with the hair all wavy Hit Lake Shore girls go all crazy Hit the freeway go at least 'bout eighty Boned so much that summer even had him a baby See back-back then-then if you had a car You was the Chi-Town version of Baby And I was just a virgin a baby One of the reasons I looked up to him crazy I used to love to play my demo tape when the system yanked Felt like I was almost signed when the shit got cranked We'll take a Saturday and just circle the mall They had they Lincolns and Auroras we was hurtin' 'em all With the girls a lotta flirtin' involved but dawg Fuck all that flirtin' I'm tryna get in some drawers so Put me on with these hoes homie He told me don't rush to get grown drive slow homie Drive slow homie drive slow homie You never know homie might meet some hoes homie You need to pump your brakes and drive slow homie What it do? I'm posted up in the parkin' lot my trunk wavin' The candy gloss is immaculate it's simply amazin' Them elbows pokin' wide on that candy 'Lac Trunk open screens on neon's lit with fifth relaxed I'm on a mission for dime pieces and sexy ladies Allow me to introduce you to my CL Mercedes It's a star-studded event when I valet park Open up my mouth and sunlight illuminates the dark You see them fo's crawlin' you see them screens fallin' The disco ball in my mouth insinuates I'm ballin' I'm leanin' on the switch sittin' crooked in my slab But I could still catch boppers if I drove a cab A young Houston hardhitter all about the scrilla Ridin' somethin' candy coated crawlin' like a caterpillar I'm tippin' on them four's I'm jammin' on that Screw I'm lookin' for them hoes baby what it do drive slow homie Turn your hazard lights on when you see them hoes (drive slow homie) If you ridin' around the city with nowhere to go (drive slow homie) Live today cause tomorrow man you never know You never know homie might meet some hoes homie You need to pump your brakes and drive slow homie My car's like the movie my car's like the crib I got more TV's in here than where I live And that don't make no sense but baby I'm the shit And everything I flip you know it's somethin' serious I got the custom grill I got the Brabus rims I got the baller genetics baby it's evident You see a player flickin' and how you ain't convinced That you should go on and kiss it Just a Lil' Bit (just a lil' bit) I got my custom kicks I got my Jesus chain My canaries is gleamin' through my angel wings They see me hoes actin like they seen a king With that mean lean smokin' on that finest Cali green My woodgrain oak I'm ridin' on Vogues My cylinder quiet like tip-toes I sold O's and this I know When you see them hoes lil' homie drive slow Drive slow homie drive slow homie You never know homie might meet some hoes homie You need to pump your brakes and drive slow homie";

    KWP_Map sortedLyrics = new KWP_Map();
    sortedLyrics.addToMap(album1, song1, lyrics1);
    sortedLyrics.addToMap(album2, song2, lyrics2);

    Scanner kb = new Scanner(System.in);
    System.out.println("Please search for a lyric:");
    String search = kb.nextLine();
    sortedLyrics.searchFor(search);
  }
}
