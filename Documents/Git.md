<h1>Git</h1>

* [Start](#start)
* [Grunder](#grunder)
* [Branch](#branch)
* [Merge och Stash](#merge-och-stash)
* [Dela och Uppdatera repository](#dela-och-uppdatera-repository)
* [Loggar](#loggar)

## Start
Beskrivning | Kommandon
----------- | ---------
Initiera ett lokalt Git repository | ``git init``
Hur man hämtar ett repository. | ``git clone https://github.com/Savalige/LoL-API-Project.git``
För att sätta upp din profil för första gången gör detta | ``git config --global user.email "you@example.com"`` <br> ``git config --global user.name "Your Name"``


## Grunder

Beskrivning | Kommandon
----------- | ---------
Hur man lägger till en fil som antingen har <br>ändrats eller skapats. | ``git add [filnamn]``
Lägger till alla nya och ändrade filer | ``git add -A``
Hur man säger att filer är redo att läggas upp. | ``git commit -m "Skriv in din kommentar här"</p>``
Hur man visar statusen på ens lokala enhet. <br>Här kan man se skillnaderna mellan det man har på ens lokala<br> enhet och det man har laddat upp på GitHub. | ``git status``
Ta bort en fil eller mapp | ``git rm -r [filnamn]``

## Branch

Beskrivning | Kommandon
----------- | ---------
Visa vilka branches som finns | ``git branch``
Visar alla branches, lokala och avlägsna | ``git branch -a``
Skapa en ny branch | ``git branch [namn_på_branch]``
För att byta namn på en branch | ``git branch [gamla_namnet] [nya_namnet]``
Ta bort en branch från din lokala enhet | ``git branch [namn_på_branch] -d``
Hur man byter mellan branches | ``git checkout [namn_på_branch]``
Skapa OCH BYT till en ny branch | ``git checkout -b [namn_på_branch]``
Byt till senast visiterad branch | ``git checkout -``
Ångra ändringar i en fil | ``git checkout -- [filnamn]``

## Merge och Stash

Beskrivning | Kommandon
----------- | ---------
Sätt ihop en branch med den aktiva branchen | ``git merge [namn_på_branch]``
Sätt ihop en branch med en annan branch | ``git merge [branch_källa] [branch_mål]``	
Lagra ändringar i ett smutsigt directory | ``git stash``	
Ta bort alla lagrade ändringar | ``git stash clear``	

## Dela och Uppdatera repository

Beskrivning | Kommandon
----------- | ---------
Hur man skickar upp ändringarna så att de inte <br>längre bara finns lokalt på din dator. | ``git push``
För att ladda upp | ``git push origin [namn_på_branch]``
För att ladda upp och minnas branchen | ``git push -u origin [namn_på_branch]``
Ta bort en branch från GitHub | ``git push origin -d [namn_på_branch]``
Hur man uppdaterar | ``git pull``
Uppdaterar från vald branch | ``git pull origin [namn_på_branch]``
Lägger till ett avlägset repository | ``git remote add origin ssh://git@github.com/[användarnamn]/[repositorynamn].git``
Sätter ett repositorys branch source till SSH | ``git remote set-url origin ssh://git@github.com/[användarnamn]/[repositorynamn].git``

## Loggar
Beskrivning | Kommandon
----------- | ---------
Visa ändringar | ``git log``
Visa ändringar (detaljerat) | ``git log --summary``
Visa ändringar (kortfattat) | ``git log --oneline``
Förhandsvisa ändringar innan merge | ``git diff [branchkälla] [branchmål]``

<!--
cd PROJECT_NAME
git remote add upstream https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git
git fetch upstream

then: (like "git pull" which is fetch + merge)
git merge upstream/master master

or, better, replay your local work on top of the fetched branch
like a "git pull --rebase"
git rebase upstream/master-->
