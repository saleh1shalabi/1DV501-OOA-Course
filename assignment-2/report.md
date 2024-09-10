# Report
Att börja med en design for ett program var en självklar smartare idé än att direkt sätta sig och coda programmet. Av egen erfarenhet, har jag sedan innan börjat med design for ett program som använde GUI i en annan tidigare kurs. Att designa hur appen skulle se ut gjorde problemet till mycket enklare problem att lösa än utan att ha någon aning om hur utseendet skulle vara bara börja coda. Återigen Det var endast utseendet av appen vad jag designade. Jag har inte varit bekant med diagrammen som presenterades under denna kurs, men som en spontan reaktion, hur lätt blir saker att göra när det finns en struktur att följa.

Eftersom det var en första gång man jobbat på detta sätt med att skapa så konkret design av implementationen av programmet och sedan börja implementationen så var det ganska svårt att komma med en så bra design som möjligt.
#
## Class Diagram
Det finns tydliga stora skillnader mellan mitt class diagram och diagrammet som presenterades exemplevis kopplingar mellan classerna, classer som saknas, methoder som är extra och mrthoder som saknas.

I designen från assignment 3 var Player classen en interface som implementerades av en HumanPlayer class. I min class diagram så fanns det inget interface utan en class som hette Player, och en annan klass som extenderade till ComputerPlayer. Detta handlar först och främst om hur mycket förstålse man hade för classer och interface classer och även förståelsen av objekt orienterad programering i den tiden man behövde lämna in assignment 2.  

En class som saknades i min design var **ConsoleUi** classen. Detta är av ren oerfarenhet, istället har jag haft en method **UpdateView()** som i prencip skulle göra hela classens jobb.

En till class som saknas i min design är **Board** classen, varför den saknades är att istället för att ha den så ser min design ut att ha det som en list av **Tils** i självaste spelet. Det som är nämnvärt är att bristen på kunskaper då fock mig att välja det och sedan implementeras av en class som har samma namn. Nu vet jag inte vad eller hur jag tänkte där och då.

Relationer och beroende mellan classerna saknades nästan helt i min design. det fanns beroende mellan spelet och player, spelet och Tiles och spelet med Dice. Men relationer eller beroende mellan Player, Dice och Tiles fanns inte och detta är såklart inte helt rätt och beroende återigen på den kunskapen man hade då.

## Objekt Diagram
Det finns stora och tydliga skillnader i objektdiagrammen. Det diagrammet som jag skapade såg ut mer att vara lik en sekvensdiagram då den visades ett flöde av händelser mer än att den visade objekt tillstånd i en viss tid. Även att det var mer ihop kopplat än det ska vara, att Player var kopplade tillsammans med Dice som vidare till Tile. Detta var klart inte ett korrekt diagram. Såklart uppenbaras det först när objektdigrammet i Assignment 3 presenterades. 

## Sekeven Diagrammet
Sekvensdiagrammen har sina stora liknelser men även sina stora skillnader. 
båda visar hur en hendelse skulle gå till, men den ena visar på väldigt konkret och korrekt sätt mer än den som jag designade som visar mer hur det skulle ske som av ren fantasi hade jag tänkt det skulle gå till. 


#
För en första gång man började med design av ett sådant på ett eller annat sätt mert komplex program än det man hade gjort tidigare och även med tanken att man är helt ny till objekt orienterat tanke sätt när det gäller programeringen tror jag att det var en bra början på designen. Exempelvis att classdiagrammet delade ut objekten i flera classer och även om en class haft den mesta delen av koden så var det ändå möjligt att implementera en sådan design med lite ändring bara.

Att jobba med detta sätt är nog mycket mer effektivt sätt att jobba efter när man ska jobba med större program, eftersom det gör det mycket lättare att veta vad man behöver göra och hur man behöver göra det. Även att det hjälper till att hålla reda och struktur i koden.

Efter att jag lärt mig designen och hur det funkar så är det nog det sättet jag kommer förlja framöver, särskilt när det gäller större program och appar.
