/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package chatbot;
import java.io.File;
import org.alicebot.ab.*;
import org.alicebot.ab.utils.IOUtils;

public class ChatBot {

    private static final boolean TRACE_MODE = false;
    static String botName = "super";
 
    public static void main(String[] args) {
        try {
 
            String resourcesPath = getResourcesPath();
            System.out.println(resourcesPath);
            MagicBooleans.trace_mode = TRACE_MODE;
            Bot bot = new Bot("super", resourcesPath);
            bot.writeAIMLFiles();
            Chat chatSession = new Chat(bot);
            //bot.brain.nodeStats();
            String textLine = "";
 
            Runtime.getRuntime().exec("clear");
            while(true) {
                System.out.print("Human : ");
                textLine = IOUtils.readInputTextLine();
                if ((textLine == null) || (textLine.length() < 1))
                    textLine = MagicStrings.null_input;
                else {
                    String request = textLine;
                    //if (MagicBooleans.trace_mode)
                        //System.out.println("STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
                    String response = chatSession.multisentenceRespond(request);
                    System.out.println("Robot : " + response);
                    if(request.toLowerCase().equals("bye"))
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path;
        return resourcesPath;
    }
}
/*OUTPUT :
/home/administrator/Desktop/AIR/chatbot
/home/administrator/Desktop/AIR/chatbot
Name = super Path = /home/administrator/Desktop/AIR/chatbot/bots/super
c:/ab
/home/administrator/Desktop/AIR/chatbot/bots
/home/administrator/Desktop/AIR/chatbot/bots/super
/home/administrator/Desktop/AIR/chatbot/bots/super/aiml
/home/administrator/Desktop/AIR/chatbot/bots/super/aimlif
/home/administrator/Desktop/AIR/chatbot/bots/super/config
/home/administrator/Desktop/AIR/chatbot/bots/super/logs
/home/administrator/Desktop/AIR/chatbot/bots/super/sets
/home/administrator/Desktop/AIR/chatbot/bots/super/maps
Preprocessor: 416 norms 56 persons 9 person2 
Get Properties: /home/administrator/Desktop/AIR/chatbot/bots/super/config/properties.txt
Exists: /home/administrator/Desktop/AIR/chatbot/bots/super/config/properties.txt
Loading AIML Sets files from /home/administrator/Desktop/AIR/chatbot/bots/super/sets
familiarname.txt
Read AIML Set familiarname
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/familiarname.txt
fastfood.txt
Read AIML Set fastfood
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/fastfood.txt
verb2st.txt
Read AIML Set verb2st
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/verb2st.txt
language.txt
Read AIML Set language
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/language.txt
bird.txt
Read AIML Set bird
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/bird.txt
mammalfeature.txt
Read AIML Set mammalfeature
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/mammalfeature.txt
profile.txt
Read AIML Set profile
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/profile.txt
color.txt
Read AIML Set color
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/color.txt
ordinal.txt
Read AIML Set ordinal
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/ordinal.txt
preposition.txt
Read AIML Set preposition
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/preposition.txt
name.txt
Read AIML Set name
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/name.txt
mammal.txt
Read AIML Set mammal
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/mammal.txt
digit.txt
Read AIML Set digit
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/digit.txt
place.txt
Read AIML Set place
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/place.txt
verb2sp.txt
Read AIML Set verb2sp
Reading AIML Set /home/administrator/Desktop/AIR/chatbot/bots/super/sets/verb2sp.txt
Loading AIML Map files from /home/administrator/Desktop/AIR/chatbot/bots/super/maps
gendername.txt
Read AIML Map gendername
Reading AIML Map /home/administrator/Desktop/AIR/chatbot/bots/super/maps/gendername.txt
profile2predicate.txt
Read AIML Map profile2predicate
Reading AIML Map /home/administrator/Desktop/AIR/chatbot/bots/super/maps/profile2predicate.txt
familiarpredicate.txt
Read AIML Map familiarpredicate
Reading AIML Map /home/administrator/Desktop/AIR/chatbot/bots/super/maps/familiarpredicate.txt
verb2sp2verb1sp.txt
Read AIML Map verb2sp2verb1sp
Reading AIML Map /home/administrator/Desktop/AIR/chatbot/bots/super/maps/verb2sp2verb1sp.txt
number2ordinal.txt
Read AIML Map number2ordinal
Reading AIML Map /home/administrator/Desktop/AIR/chatbot/bots/super/maps/number2ordinal.txt
ordinal2number.txt
Read AIML Map ordinal2number
Reading AIML Map /home/administrator/Desktop/AIR/chatbot/bots/super/maps/ordinal2number.txt
AIML modified Wed Oct 03 10:58:04 IST 2018 AIMLIF modified Wed Oct 03 10:59:30 IST 2018
No deleted.aiml.csv file found
No deleted.aiml.csv file found
Loading AIML files from /home/administrator/Desktop/AIR/chatbot/bots/super/aimlif
AIML Set birdfeature not found.
AIML Set birdfeature not found.
Reading Learnf file
Loaded 4846 categories in 0.435 sec
--> Bot super 4846 completed 0 deleted 0 unfinished
Human : Hi
Robot : Hi nice to see you!
Human : How are you
Robot : Feeling really joyful today.
Human : by
Robot : Looking forward to our next time together.
Human : done
Robot : Are you a man or a woman?
Human : woman
Robot : Good to know.
Human : good by
Robot : It only gets better.
Human : exit
Robot : How old are you?
Human : quit
Robot : How many years old are you?
Human : clear
Robot : Done. <oob><clear>log</clear></oob>
Human : 
*/