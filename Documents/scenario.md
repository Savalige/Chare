## Scenario 1: Skapa ett repository(lokalt) och ladda en fil

git clone https://github.com/[Användarnamn]/[Repository_Namn]

git add [filnamn]

git commit -m "Kommentar"

git push

Beskrivning | Kommandon
----------- | ---------
Initiera ett lokalt Git project | ``git init``

## Scenario 2: Skapa en branch lägg till något där och sedan merge med main, kolla ändringar innan merge

git branch

git branch [namn_på_branch]

git branch

git checkout [namn_på_branch]

skapa fil

git add [filnamn]

git commit -m "Kommentar"

git push -u origin [namn_på_branch]

git checkout master

git diff [branchkälla] [branchmål]

git merge [namn_på_branch]

git branch



Beskrivning | Kommandon
----------- | ---------
Initiera ett lokalt Git project | ``git init``


## Scenario 3: Uppdatera från specifik branch, byt namn och pusha upp

git branch

git pull origin [namn_på_branch]

git branch [gamla_namnet] [nya_namnet]

git branch

git log

git push -u origin [namn_på_branch]

Beskrivning | Kommandon
----------- | ---------
Initiera ett lokalt Git project | ``git init``

