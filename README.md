# Első kötelező beadandó

## 1 RÉSZ

### 1.1 FELADATLEÍRÁS

Készítsük el egy állatkert állataira vonatkozó nyilvántartását.
A nyilvántartásba lehetőségünk legyen felvenni egy új állatot, törölni egy állatot, illetve megjelölni
"kölcsönadottként". Ez utóbbi megjelölés azt jelenti, hogy az adott állatot egy másik állatkert számára
kölcsönadtuk egy időre.

A nyilvántartásba vehető minden állatnak van neve, fajtája, általános lelőhelye és egy egyedi
azonosítója.

Az alkalmazást elindítva inicializálja a belső adatstruktúrát, majd várja a felhasználó parancsát a
standard input-on.

A felhasználó által megadható parancsok a következők lehetnek:

**$ exit**

```
Az alkalmazás bezárását végzi el.
```
**$ add**

```
A bekéri egy állat paramétereit és lementi azt. Ezzel a paranccsal nyilvántartásba veszünk egy új,
az állatkertbe érkező állatot.
```
**$ list**

```
Írjuk ki a konzolra az összes nyilvántartásba vett állatot, minden adatával együtt, nevük szerint
ABC sorrendben.
```
**$ list desc**

```
Írjuk ki a konzolra az összes nyilvántartásba vett állatot, minden adatával együtt, nevük szerint
csökkenő sorrendben.
```
## 2 RÉSZ

### 2.1 FELADATLEÍRÁS

Egészítsük ki az állatkerti nyilvántartásunkat a kölcsönadott funkcióval. Felhasználói oldalról az alábbi
új parancsokat jelenti:

**$ loan**

```
A parancs kiadása után az alkalmazás bekéri a kezelendő állat azonosítóját, majd ellenőrzi, hogy a
megadott azonosítóval állat regisztrálva van-e a nyilvántartásban. Ha nincs regisztrálva, akkor
```

```
erről tájékoztassa a felhasználót. Ha regisztrálva van, akkor írja ki az adott állat adatait a
kölcsönadás státuszával együtt. (Jelenleg kölcsönadott állatként van-e regisztrálva, vagy sem.)
```
```
Ezután kérje be a felhasználótól, hogy mit is szeretnénk csinálni a megadott állattal:
```
- kölcsön szeretnénk adni
- más állatkertnek kölcsönadtuk és most visszajuttatták hozzánk
- mégse

```
A megadott műveletet hajtsuk végre!
```
A megoldás során optimalizáljuk a belső struktúrát oly módon, hogy egy állat azonosító alapján való
lekérdezése, illetve adatainak módosítása hatékony legyen!

### 2.2 FELADATLEÍRÁS

Egészítsük ki az állatkerti nyilvántartásunkat az állatok etetését segítő funkciókkal. Az állatkerti
dolgozók minden állat táplálkozási szokásait és forrását ismerik. Ellenben előfordulhatnak az
egyedekre vonatkozó egyedi, különleges előírások is, melyeket az állatorvosokok írnak fel betegség,
vemhesség vagy egyéb befolyásoló tényezők alapján. A nyilvántartásunkban az adott egyedek
számára vonatkozó speciális táplálékokat kell kezelnünk, mely az állatkerti dolgozók munkáját
segítheti.

Az alkalmazásnak az alábbi parancsokat kell tudnia kezelnie:

**$ nutrition <állat azonosítója/neve> add <táplálék/vagy orvosi előírás szövege>**

```
Ezzel a paranccsal az adott egyed számára különleges táplálékot, illetve egyéb orvosi előírást
felvenni. Az állatot fel kell ismernünk azonosító és név alapján is!
```
**$ nutrition <állat azonosítója/neve> list**

```
Ezzel a paranccsal az adott egyed számára felírt különleges táplálékokat, illetve egyéb orvosi
előírásokat listázhatjuk ki. Az állatot fel kell ismernünk azonosító és név alapján is!
```
**$ ???**

```
Ha egy példánynak már nincs szüksége a felírt különleges táplálékra vagy előírásra, törölnünk kell
tudni azt. A feladat része azt is kitalálni, hogy mi legyen az a parancs.
```
## 3 RÉSZ

### 3.1 FELADATLEÍRÁS

Támogassuk meg a nyilvántartó alkalmazásunkat exportálás, illetve importálás funkcióval! Ehhez a
felhasználói interfész oldaláról két újabb parancsra lesz szükség:

**$ export**

```
A parancs kiadása után kérjünk be egy fájlnevet (elérési útvonalat), majd írjük ki a megadott fájlba
minden regisztrált állatot valamilyen tetszőleges struktúrában.
```
**$ import**


A parancs kiadása után kérjünk be egy fájlnevet (elérési útvonalat), majd a megadott fájlt,
amennyiben az létezik, olvassuk be és tartalmát, azaz a benne található állatokat regisztráljuk a
rendszerbe. Feltételezhetjük, hogy amennyiben a fájl létezik, tartalma, illetve struktúrája helyes.


