BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Gedeckt" (
	"GedecktID"	TEXT NOT NULL,
	"SchafID"	TEXT NOT NULL,
	"VaterKennung"	TEXT NOT NULL,
	"Datum"	TEXT NOT NULL,
	PRIMARY KEY("GedecktID")
);
CREATE TABLE IF NOT EXISTS "Entwurmen" (
	"EntwurmenID"	TEXT NOT NULL,
	"SchafID"	TEXT NOT NULL,
	"Datum"	TEXT NOT NULL,
	PRIMARY KEY("EntwurmenID")
);
CREATE TABLE IF NOT EXISTS "Betriebsnummer" (
	"BetriebsID"	TEXT NOT NULL,
	"SchafID"	TEXT NOT NULL,
	"Betriebsnummer"	TEXT NOT NULL,
	"Bemerkung"	TEXT,
	PRIMARY KEY("BetriebsID")
);
CREATE TABLE IF NOT EXISTS "Impfungen" (
	"ImpfID"	TEXT NOT NULL,
	"SchafID"	TEXT NOT NULL,
	"Impfstoff"	TEXT NOT NULL,
	"Bemerkung"	TEXT,
	"Datum"	TEXT NOT NULL,
	PRIMARY KEY("ImpfID")
);
CREATE TABLE IF NOT EXISTS "Klauenschneiden" (
	"KlauenID"	TEXT NOT NULL,
	"SchafID"	TEXT NOT NULL,
	"Datum"	TEXT NOT NULL,
	PRIMARY KEY("KlauenID")
);
CREATE TABLE IF NOT EXISTS "Schaf" (
	"SchafID"	TEXT NOT NULL,
	"DatumZugang"	TEXT,
	"DatumAbgang"	TEXT,
	"GrundFürAbgang"	TEXT,
	"Kennung"	TEXT,
	"Bemerkung"	TEXT,
	"MutterKennung"	TEXT,
	PRIMARY KEY("SchafID")
);
CREATE TABLE IF NOT EXISTS "Schur" (
	"SchurID"	TEXT NOT NULL,
	"SchafID"	TEXT NOT NULL,
	"Datum"	TEXT NOT NULL,
	PRIMARY KEY("SchurID")
);
CREATE TABLE IF NOT EXISTS "Transport" (
	"TransportID"	TEXT NOT NULL,
	"SchafID"	TEXT NOT NULL,
	"TransportMittel"	TEXT NOT NULL,
	"Grund"	TEXT,
	"Datum"	TEXT NOT NULL,
	PRIMARY KEY("TransportID")
);
COMMIT;
