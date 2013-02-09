--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.3
-- Dumped by pg_dump version 9.1.3
-- Started on 2012-11-05 18:36:59 WET

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 184 (class 3079 OID 11683)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 184
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 161 (class 1259 OID 42329)
-- Dependencies: 5
-- Name: article; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE article (
    idarticle character varying(254) NOT NULL,
    descarticle character varying(254),
    qntarticle integer,
    marque character varying(254),
    refcommerciale character varying(254),
    refcommande character varying(254),
    unite character varying(254),
    categorie character varying(254),
    fourniture character varying(255)
);


ALTER TABLE public.article OWNER TO postgres;

--
-- TOC entry 162 (class 1259 OID 42338)
-- Dependencies: 5
-- Name: audit; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE audit (
    idaudit character varying(254) NOT NULL,
    typeoperation character varying(254),
    userid character varying(254),
    username character varying(254),
    typemodification character varying(254),
    dateaudit date,
    heuraudit integer
);


ALTER TABLE public.audit OWNER TO postgres;

--
-- TOC entry 163 (class 1259 OID 42347)
-- Dependencies: 5
-- Name: besoin; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE besoin (
    idbesoin character varying(254) NOT NULL,
    numtache character varying(254) NOT NULL,
    datebesoin date,
    descbesoin character varying(254),
    valider character varying
);


ALTER TABLE public.besoin OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 42791)
-- Dependencies: 5
-- Name: boncc; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE boncc (
    numboncc character varying(255) NOT NULL,
    dateboncc date,
    idprojet character varying
);


ALTER TABLE public.boncc OWNER TO postgres;

--
-- TOC entry 164 (class 1259 OID 42357)
-- Dependencies: 5
-- Name: boncommande; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE boncommande (
    numbc character varying(254) NOT NULL,
    idfournisseur character varying(254) NOT NULL,
    idprojet character varying(254) NOT NULL,
    dateboncommande date,
    prixht numeric,
    urgent boolean
);


ALTER TABLE public.boncommande OWNER TO postgres;

--
-- TOC entry 165 (class 1259 OID 42368)
-- Dependencies: 5
-- Name: bonreception; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bonreception (
    numreception character varying(254) NOT NULL,
    numbc character varying(254) NOT NULL,
    datereception date
);


ALTER TABLE public.bonreception OWNER TO postgres;

--
-- TOC entry 166 (class 1259 OID 42378)
-- Dependencies: 5
-- Name: bonsortie; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bonsortie (
    idsortie character varying(254) NOT NULL,
    numtache character varying(254) NOT NULL,
    idpersonnel character varying(254) NOT NULL,
    datesortie date,
    descsortie character varying(254)
);


ALTER TABLE public.bonsortie OWNER TO postgres;

--
-- TOC entry 167 (class 1259 OID 42389)
-- Dependencies: 5
-- Name: client; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE client (
    idclient character varying(254) NOT NULL,
    nomclient character varying(254),
    email character varying(254),
    tel character varying(254),
    fax character varying(254),
    adresse character varying(254),
    description character varying(254),
    contact character varying(255),
    fcontact character varying(255)
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 42398)
-- Dependencies: 5
-- Name: demandeprix; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE demandeprix (
    numdemandeprix character varying(254) NOT NULL,
    idfournisseur character varying(254) NOT NULL,
    referencedemandeprix character varying(254),
    datedemandeprix date
);


ALTER TABLE public.demandeprix OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 42408)
-- Dependencies: 5
-- Name: detailsarticlbesoin; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detailsarticlbesoin (
    idbesoin character varying(254) NOT NULL,
    idarticle character varying(254) NOT NULL,
    qntbesoin integer
);


ALTER TABLE public.detailsarticlbesoin OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 42419)
-- Dependencies: 5
-- Name: detailsbcarticle; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detailsbcarticle (
    numbc character varying(254) NOT NULL,
    idarticle character varying(254) NOT NULL,
    qntcommande integer,
    prixunitaire numeric,
    qntlivre integer
);


ALTER TABLE public.detailsbcarticle OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 42441)
-- Dependencies: 5
-- Name: detailsbrarticle; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detailsbrarticle (
    idarticle character varying(254) NOT NULL,
    numreception character varying(254) NOT NULL,
    qntlivre integer
);


ALTER TABLE public.detailsbrarticle OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 42463)
-- Dependencies: 5
-- Name: detailsdemandearticle; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detailsdemandearticle (
    numdemandeprix character varying(254) NOT NULL,
    idarticle character varying(254) NOT NULL,
    qntdemande integer
);


ALTER TABLE public.detailsdemandearticle OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 42485)
-- Dependencies: 5
-- Name: detailsprivuser; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detailsprivuser (
    idpersonnel character varying(254) NOT NULL,
    idpriv character varying(254) NOT NULL,
    description character varying(254)
);


ALTER TABLE public.detailsprivuser OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 42496)
-- Dependencies: 5
-- Name: detailssortiearticle; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detailssortiearticle (
    idsortie character varying(254) NOT NULL,
    idarticle character varying(254) NOT NULL,
    qntsortie integer,
    qntretour integer
);


ALTER TABLE public.detailssortiearticle OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 42518)
-- Dependencies: 5
-- Name: detailstachepersonnel; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detailstachepersonnel (
    numtache character varying(254) NOT NULL,
    idpersonnel character varying(254) NOT NULL,
    datedebut date,
    datefin date
);


ALTER TABLE public.detailstachepersonnel OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 42548)
-- Dependencies: 5
-- Name: fournisseur; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fournisseur (
    idfournisseur character varying(254) NOT NULL,
    nom character varying(254),
    email character varying(254),
    tel character varying(254),
    fax character varying(254),
    adresse character varying(254),
    description character varying(254),
    contact character varying(255),
    fcontact character varying(255)
);


ALTER TABLE public.fournisseur OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 42566)
-- Dependencies: 5
-- Name: personnel; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personnel (
    idpersonnel character varying(254) NOT NULL,
    typeuser integer NOT NULL,
    nom character varying(254),
    prenom character varying(254),
    datenaissance date,
    adresse character varying(254),
    tel character varying(254),
    email character varying(254),
    description character varying(254),
    fonction character varying(254),
    password character varying(254)
);


ALTER TABLE public.personnel OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 42576)
-- Dependencies: 5
-- Name: privilege; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE privilege (
    idpriv character varying(254) NOT NULL,
    lienpriv character varying(254),
    nompriv character varying(254)
);


ALTER TABLE public.privilege OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 42585)
-- Dependencies: 5
-- Name: projet; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE projet (
    idprojet character varying(254) NOT NULL,
    idclient character varying(254) NOT NULL,
    datedebutaffaire date,
    descprojet character varying(254),
    dateintervention date,
    lieuintervention character varying(254),
    typeprojet character varying(254),
    datedevis date,
    montantdevis double precision,
    liendevis character varying,
    numfacture character varying,
    numdevis character varying(254),
    datefacture date,
    montantfacture double precision,
    lienfacture character varying
);


ALTER TABLE public.projet OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 42595)
-- Dependencies: 5
-- Name: soustache; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE soustache (
    idsousprojet character varying(254) NOT NULL,
    numtache character varying(254) NOT NULL,
    descsousprojet character varying(254)
);


ALTER TABLE public.soustache OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 42605)
-- Dependencies: 5
-- Name: tache; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tache (
    numtache character varying(254) NOT NULL,
    idprojet character varying(254) NOT NULL,
    designationtache character varying(254),
    durefabrication integer,
    lienimplementation character varying(254),
    lienschema character varying(254),
    lieutache character varying(254),
    typetache character varying(254)
);


ALTER TABLE public.tache OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 42615)
-- Dependencies: 5
-- Name: typeuser; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE typeuser (
    typeuser integer NOT NULL,
    nompriv character varying(254)
);


ALTER TABLE public.typeuser OWNER TO postgres;

--
-- TOC entry 2115 (class 0 OID 42329)
-- Dependencies: 161
-- Data for Name: article; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY article (idarticle, descarticle, qntarticle, marque, refcommerciale, refcommande, unite, categorie, fourniture) FROM stdin;
A1	psqdqs	12	ssddfd	\N	\N	\N	\N	\N
A2	zk,ksds	21	mlk,kn	\N	\N	\N	\N	\N
A3	qsdsd	10	slsd,lk	zez	sdss	kg	anaa	\N
A5	dsfsdsds	4	dslfdsfs			mo		\N
A4	sfff	2	dsdsff	za	ssd	kg		\N
\.


--
-- TOC entry 2116 (class 0 OID 42338)
-- Dependencies: 162
-- Data for Name: audit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY audit (idaudit, typeoperation, userid, username, typemodification, dateaudit, heuraudit) FROM stdin;
\.


--
-- TOC entry 2117 (class 0 OID 42347)
-- Dependencies: 163
-- Data for Name: besoin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY besoin (idbesoin, numtache, datebesoin, descbesoin, valider) FROM stdin;
B1	T1	2012-09-16	besoin1	oui
B2	T2	2012-09-17	besoin2	non
\.


--
-- TOC entry 2137 (class 0 OID 42791)
-- Dependencies: 183
-- Data for Name: boncc; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY boncc (numboncc, dateboncc, idprojet) FROM stdin;
aa	2012-09-13	AF2
BC2	2012-09-13	AF2
BC5	2012-09-13	AF3
\.


--
-- TOC entry 2118 (class 0 OID 42357)
-- Dependencies: 164
-- Data for Name: boncommande; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY boncommande (numbc, idfournisseur, idprojet, dateboncommande, prixht, urgent) FROM stdin;
BC1	F1	AF3	2012-09-14	0	f
BC2	F3	AF2	2012-09-16	3000	f
\.


--
-- TOC entry 2119 (class 0 OID 42368)
-- Dependencies: 165
-- Data for Name: bonreception; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bonreception (numreception, numbc, datereception) FROM stdin;
BL1	BC1	2012-09-15
\.


--
-- TOC entry 2120 (class 0 OID 42378)
-- Dependencies: 166
-- Data for Name: bonsortie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bonsortie (idsortie, numtache, idpersonnel, datesortie, descsortie) FROM stdin;
BS1	T1	admin2	2012-09-16	RAS
\.


--
-- TOC entry 2121 (class 0 OID 42389)
-- Dependencies: 167
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY client (idclient, nomclient, email, tel, fax, adresse, description, contact, fcontact) FROM stdin;
C1	Copag		7878878875	7887868997	taroudant	dffkkf,dfn	\N	\N
C2	ensa	zaae@sdlk.com	2334353253	3233433434	agadir	ecole nationale	\N	\N
C3	marissa		4543445535	4557776665	ait melloul	dffkkf,dfn	\N	\N
C4	Copaga		7878878875	7887868997	agadir	dffkkf,dfn	\N	\N
C5	azarit informatik		3344512423		ksjdfkf		\N	\N
C6	zekzekj		3344512423		ksjdfkf		\N	\N
C7	Fantasia	kfffgf@dfjf.com	3456678882	2445566654	nlkjkjkl	dsdds	Boullouz mohamed	directeur
\.


--
-- TOC entry 2122 (class 0 OID 42398)
-- Dependencies: 168
-- Data for Name: demandeprix; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY demandeprix (numdemandeprix, idfournisseur, referencedemandeprix, datedemandeprix) FROM stdin;
D11	F1	D1	2012-08-31
D12	F2	D1	2012-08-31
D21	F3	D2	2012-08-30
D22	F2	D2	2012-08-30
D31	F3	D3	2012-08-31
D32	F2	D3	2012-08-31
\.


--
-- TOC entry 2123 (class 0 OID 42408)
-- Dependencies: 169
-- Data for Name: detailsarticlbesoin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detailsarticlbesoin (idbesoin, idarticle, qntbesoin) FROM stdin;
B1	A1	11
B1	A3	10
\.


--
-- TOC entry 2124 (class 0 OID 42419)
-- Dependencies: 170
-- Data for Name: detailsbcarticle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detailsbcarticle (numbc, idarticle, qntcommande, prixunitaire, qntlivre) FROM stdin;
BC2	A2	12	100	0
BC2	A5	12	150	0
\.


--
-- TOC entry 2125 (class 0 OID 42441)
-- Dependencies: 171
-- Data for Name: detailsbrarticle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detailsbrarticle (idarticle, numreception, qntlivre) FROM stdin;
\.


--
-- TOC entry 2126 (class 0 OID 42463)
-- Dependencies: 172
-- Data for Name: detailsdemandearticle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detailsdemandearticle (numdemandeprix, idarticle, qntdemande) FROM stdin;
D11	A1	11
D11	A2	11
D12	A1	11
D12	A2	11
D21	A3	10
D31	A4	9
D31	A3	2
D32	A4	9
D32	A3	2
\.


--
-- TOC entry 2127 (class 0 OID 42485)
-- Dependencies: 173
-- Data for Name: detailsprivuser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detailsprivuser (idpersonnel, idpriv, description) FROM stdin;
user2	1	Gestion Commerciale
user2	2	Gestion Technique
user2	3	Gestion Magasin
user1	1	Gestion Commerciale
user1	2	Gestion Technique
user1	3	Gestion Magasin
user1	5	Historique/Statistiques
\.


--
-- TOC entry 2128 (class 0 OID 42496)
-- Dependencies: 174
-- Data for Name: detailssortiearticle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detailssortiearticle (idsortie, idarticle, qntsortie, qntretour) FROM stdin;
BS1	A3	0	0
BS1	A1	0	0
\.


--
-- TOC entry 2129 (class 0 OID 42518)
-- Dependencies: 175
-- Data for Name: detailstachepersonnel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detailstachepersonnel (numtache, idpersonnel, datedebut, datefin) FROM stdin;
T1	user2	2012-09-08	2012-09-09
T2	user2	2012-09-05	2012-09-06
\.


--
-- TOC entry 2130 (class 0 OID 42548)
-- Dependencies: 176
-- Data for Name: fournisseur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY fournisseur (idfournisseur, nom, email, tel, fax, adresse, description, contact, fcontact) FROM stdin;
F1	electro	zzaa	2324	243343			\N	\N
F2	zeeze	zaze	2343433	33445545			\N	\N
F3	ezesdfs		33434	3454			Trimasse	comptable
\.


--
-- TOC entry 2131 (class 0 OID 42566)
-- Dependencies: 177
-- Data for Name: personnel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY personnel (idpersonnel, typeuser, nom, prenom, datenaissance, adresse, tel, email, description, fonction, password) FROM stdin;
admin	1	admin	lds	\N	\N	\N	\N	directeur	directeur	admin
admin2	1	abdallah	farouk	1985-08-12	agadir	4565657656			responsable technique	admin2
user1	2	ahmed	oussous	1987-01-30	ait melloul	2132434545	zare@dk.com	sdkldfsjkj	mecanicien	user1
user2	2	ouattara	ousmane	1989-08-01	massira agadir	2343242142			marketeur	user2
\.


--
-- TOC entry 2132 (class 0 OID 42576)
-- Dependencies: 178
-- Data for Name: privilege; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY privilege (idpriv, lienpriv, nompriv) FROM stdin;
1	/LeaderAS/faces/vue/commercial/accueil.xhtml?id=1	Gestion Commerciale
2	/LeaderAS/faces/vue/technique/accueil.xhtml?id=2	Gestion Technique
3	/LeaderAS/faces/vue/magasin/accueil.xhtml?id=3	Gestion Magasin
5	/LeaderAS/faces/vue/stats/accueil.xhtml?id=5	Historique/Statistiques
4	/LeaderAS/faces/vue/client-fournisseur/accueil.xhtml?id=4	Clients/Fournisseurs
\.


--
-- TOC entry 2133 (class 0 OID 42585)
-- Dependencies: 179
-- Data for Name: projet; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY projet (idprojet, idclient, datedebutaffaire, descprojet, dateintervention, lieuintervention, typeprojet, datedevis, montantdevis, liendevis, numfacture, numdevis, datefacture, montantfacture, lienfacture) FROM stdin;
I1	C4	\N	kljkqjkj	2012-09-03	agadir	2	\N	\N	\N	\N	\N	\N	\N	\N
AF3	C7	2012-09-13		\N	\N	1	2012-09-20	5000	\N	004	55	2012-09-13	5000	/LeaderAS/faces/files/aids2.pdf
AF2	C2	2012-09-12	zazz	\N	\N	1	\N	123	../../files/prog.pdf	33	22	\N	2233	../../files/aids2.pdf
AF1	C4	\N		\N	\N	1	\N	0	../../files/prog.pdf		22	\N	0	../../files/aids2.pdf
\.


--
-- TOC entry 2134 (class 0 OID 42595)
-- Dependencies: 180
-- Data for Name: soustache; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY soustache (idsousprojet, numtache, descsousprojet) FROM stdin;
ST	T1	demontage
ST2	T2	peinture
\.


--
-- TOC entry 2135 (class 0 OID 42605)
-- Dependencies: 181
-- Data for Name: tache; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tache (numtache, idprojet, designationtache, durefabrication, lienimplementation, lienschema, lieutache, typetache) FROM stdin;
T1	AF1	tache1	3	\N	prog.pdf	\N	Chantier
T2	AF1	tache2	3	\N	\N	\N	Chantier
\.


--
-- TOC entry 2136 (class 0 OID 42615)
-- Dependencies: 182
-- Data for Name: typeuser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY typeuser (typeuser, nompriv) FROM stdin;
1	admin
2	user
\.


--
-- TOC entry 2001 (class 2606 OID 42336)
-- Dependencies: 161 161
-- Name: pk_article; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY article
    ADD CONSTRAINT pk_article PRIMARY KEY (idarticle);


--
-- TOC entry 2004 (class 2606 OID 42345)
-- Dependencies: 162 162
-- Name: pk_audit; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY audit
    ADD CONSTRAINT pk_audit PRIMARY KEY (idaudit);


--
-- TOC entry 2008 (class 2606 OID 42354)
-- Dependencies: 163 163
-- Name: pk_besoin; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY besoin
    ADD CONSTRAINT pk_besoin PRIMARY KEY (idbesoin);


--
-- TOC entry 2091 (class 2606 OID 42798)
-- Dependencies: 183 183
-- Name: pk_boncc; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY boncc
    ADD CONSTRAINT pk_boncc PRIMARY KEY (numboncc);


--
-- TOC entry 2013 (class 2606 OID 42364)
-- Dependencies: 164 164
-- Name: pk_boncommande; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY boncommande
    ADD CONSTRAINT pk_boncommande PRIMARY KEY (numbc);


--
-- TOC entry 2017 (class 2606 OID 42375)
-- Dependencies: 165 165
-- Name: pk_bonreception; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bonreception
    ADD CONSTRAINT pk_bonreception PRIMARY KEY (numreception);


--
-- TOC entry 2022 (class 2606 OID 42385)
-- Dependencies: 166 166
-- Name: pk_bonsortie; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bonsortie
    ADD CONSTRAINT pk_bonsortie PRIMARY KEY (idsortie);


--
-- TOC entry 2025 (class 2606 OID 42396)
-- Dependencies: 167 167
-- Name: pk_client; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY client
    ADD CONSTRAINT pk_client PRIMARY KEY (idclient);


--
-- TOC entry 2029 (class 2606 OID 42405)
-- Dependencies: 168 168
-- Name: pk_demandeprix; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY demandeprix
    ADD CONSTRAINT pk_demandeprix PRIMARY KEY (numdemandeprix);


--
-- TOC entry 2034 (class 2606 OID 42415)
-- Dependencies: 169 169 169
-- Name: pk_detailsarticlbesoin; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detailsarticlbesoin
    ADD CONSTRAINT pk_detailsarticlbesoin PRIMARY KEY (idbesoin, idarticle);


--
-- TOC entry 2039 (class 2606 OID 42426)
-- Dependencies: 170 170 170
-- Name: pk_detailsbcarticle; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detailsbcarticle
    ADD CONSTRAINT pk_detailsbcarticle PRIMARY KEY (numbc, idarticle);


--
-- TOC entry 2044 (class 2606 OID 42448)
-- Dependencies: 171 171 171
-- Name: pk_detailsbrarticle; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detailsbrarticle
    ADD CONSTRAINT pk_detailsbrarticle PRIMARY KEY (idarticle, numreception);


--
-- TOC entry 2049 (class 2606 OID 42470)
-- Dependencies: 172 172 172
-- Name: pk_detailsdemandearticle; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detailsdemandearticle
    ADD CONSTRAINT pk_detailsdemandearticle PRIMARY KEY (numdemandeprix, idarticle);


--
-- TOC entry 2054 (class 2606 OID 42492)
-- Dependencies: 173 173 173
-- Name: pk_detailsprivuser; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detailsprivuser
    ADD CONSTRAINT pk_detailsprivuser PRIMARY KEY (idpersonnel, idpriv);


--
-- TOC entry 2059 (class 2606 OID 42503)
-- Dependencies: 174 174 174
-- Name: pk_detailssortiearticle; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detailssortiearticle
    ADD CONSTRAINT pk_detailssortiearticle PRIMARY KEY (idsortie, idarticle);


--
-- TOC entry 2064 (class 2606 OID 42525)
-- Dependencies: 175 175 175
-- Name: pk_detailstachepersonnel; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detailstachepersonnel
    ADD CONSTRAINT pk_detailstachepersonnel PRIMARY KEY (numtache, idpersonnel);


--
-- TOC entry 2067 (class 2606 OID 42555)
-- Dependencies: 176 176
-- Name: pk_fournisseur; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fournisseur
    ADD CONSTRAINT pk_fournisseur PRIMARY KEY (idfournisseur);


--
-- TOC entry 2071 (class 2606 OID 42573)
-- Dependencies: 177 177
-- Name: pk_personnel; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personnel
    ADD CONSTRAINT pk_personnel PRIMARY KEY (idpersonnel);


--
-- TOC entry 2073 (class 2606 OID 42583)
-- Dependencies: 178 178
-- Name: pk_privilege; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY privilege
    ADD CONSTRAINT pk_privilege PRIMARY KEY (idpriv);


--
-- TOC entry 2077 (class 2606 OID 42592)
-- Dependencies: 179 179
-- Name: pk_projet; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY projet
    ADD CONSTRAINT pk_projet PRIMARY KEY (idprojet);


--
-- TOC entry 2081 (class 2606 OID 42602)
-- Dependencies: 180 180
-- Name: pk_soustache; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY soustache
    ADD CONSTRAINT pk_soustache PRIMARY KEY (idsousprojet);


--
-- TOC entry 2084 (class 2606 OID 42612)
-- Dependencies: 181 181
-- Name: pk_tache; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tache
    ADD CONSTRAINT pk_tache PRIMARY KEY (numtache);


--
-- TOC entry 2088 (class 2606 OID 42619)
-- Dependencies: 182 182
-- Name: pk_typeuser; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY typeuser
    ADD CONSTRAINT pk_typeuser PRIMARY KEY (typeuser);


--
-- TOC entry 1999 (class 1259 OID 42337)
-- Dependencies: 161
-- Name: article_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX article_pk ON article USING btree (idarticle);


--
-- TOC entry 2014 (class 1259 OID 42377)
-- Dependencies: 165
-- Name: association10_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association10_fk ON bonreception USING btree (numbc);


--
-- TOC entry 2035 (class 1259 OID 42428)
-- Dependencies: 170
-- Name: association11_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association11_fk ON detailsbcarticle USING btree (numbc);


--
-- TOC entry 2040 (class 1259 OID 42450)
-- Dependencies: 171
-- Name: association12_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association12_fk ON detailsbrarticle USING btree (numreception);


--
-- TOC entry 2055 (class 1259 OID 42505)
-- Dependencies: 174
-- Name: association13_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association13_fk ON detailssortiearticle USING btree (idsortie);


--
-- TOC entry 2018 (class 1259 OID 42387)
-- Dependencies: 166
-- Name: association14_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association14_fk ON bonsortie USING btree (idpersonnel);


--
-- TOC entry 2060 (class 1259 OID 42527)
-- Dependencies: 175
-- Name: association18_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association18_fk ON detailstachepersonnel USING btree (numtache);


--
-- TOC entry 2061 (class 1259 OID 42528)
-- Dependencies: 175
-- Name: association18_fk2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association18_fk2 ON detailstachepersonnel USING btree (idpersonnel);


--
-- TOC entry 2019 (class 1259 OID 42388)
-- Dependencies: 166
-- Name: association19_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association19_fk ON bonsortie USING btree (numtache);


--
-- TOC entry 2068 (class 1259 OID 42575)
-- Dependencies: 177
-- Name: association20_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association20_fk ON personnel USING btree (typeuser);


--
-- TOC entry 2009 (class 1259 OID 42367)
-- Dependencies: 164
-- Name: association21_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association21_fk ON boncommande USING btree (idprojet);


--
-- TOC entry 2075 (class 1259 OID 42594)
-- Dependencies: 179
-- Name: association22_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association22_fk ON projet USING btree (idclient);


--
-- TOC entry 2026 (class 1259 OID 42407)
-- Dependencies: 168
-- Name: association23_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association23_fk ON demandeprix USING btree (idfournisseur);


--
-- TOC entry 2079 (class 1259 OID 42604)
-- Dependencies: 180
-- Name: association25_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association25_fk ON soustache USING btree (numtache);


--
-- TOC entry 2005 (class 1259 OID 42356)
-- Dependencies: 163
-- Name: association5_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association5_fk ON besoin USING btree (numtache);


--
-- TOC entry 2045 (class 1259 OID 42472)
-- Dependencies: 172
-- Name: association8_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association8_fk ON detailsdemandearticle USING btree (numdemandeprix);


--
-- TOC entry 2010 (class 1259 OID 42366)
-- Dependencies: 164
-- Name: association9_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX association9_fk ON boncommande USING btree (idfournisseur);


--
-- TOC entry 2002 (class 1259 OID 42346)
-- Dependencies: 162
-- Name: audit_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX audit_pk ON audit USING btree (idaudit);


--
-- TOC entry 2006 (class 1259 OID 42355)
-- Dependencies: 163
-- Name: besoin_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX besoin_pk ON besoin USING btree (idbesoin);


--
-- TOC entry 2011 (class 1259 OID 42365)
-- Dependencies: 164
-- Name: boncommande_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX boncommande_pk ON boncommande USING btree (numbc);


--
-- TOC entry 2015 (class 1259 OID 42376)
-- Dependencies: 165
-- Name: bonreception_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX bonreception_pk ON bonreception USING btree (numreception);


--
-- TOC entry 2020 (class 1259 OID 42386)
-- Dependencies: 166
-- Name: bonsortie_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX bonsortie_pk ON bonsortie USING btree (idsortie);


--
-- TOC entry 2023 (class 1259 OID 42397)
-- Dependencies: 167
-- Name: client_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX client_pk ON client USING btree (idclient);


--
-- TOC entry 2027 (class 1259 OID 42406)
-- Dependencies: 168
-- Name: demandeprix_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX demandeprix_pk ON demandeprix USING btree (numdemandeprix);


--
-- TOC entry 2030 (class 1259 OID 42416)
-- Dependencies: 169 169
-- Name: detailsarticlbesoin_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX detailsarticlbesoin_pk ON detailsarticlbesoin USING btree (idbesoin, idarticle);


--
-- TOC entry 2031 (class 1259 OID 42417)
-- Dependencies: 169
-- Name: detailsarticlebesoin_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detailsarticlebesoin_fk ON detailsarticlbesoin USING btree (idbesoin);


--
-- TOC entry 2032 (class 1259 OID 42418)
-- Dependencies: 169
-- Name: detailsarticlebesoin_fk2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detailsarticlebesoin_fk2 ON detailsarticlbesoin USING btree (idarticle);


--
-- TOC entry 2036 (class 1259 OID 42429)
-- Dependencies: 170
-- Name: detailsbcarticle_fk2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detailsbcarticle_fk2 ON detailsbcarticle USING btree (idarticle);


--
-- TOC entry 2037 (class 1259 OID 42427)
-- Dependencies: 170 170
-- Name: detailsbcarticle_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX detailsbcarticle_pk ON detailsbcarticle USING btree (numbc, idarticle);


--
-- TOC entry 2056 (class 1259 OID 42506)
-- Dependencies: 174
-- Name: detailsbonsortieelement_fk2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detailsbonsortieelement_fk2 ON detailssortiearticle USING btree (idarticle);


--
-- TOC entry 2041 (class 1259 OID 42451)
-- Dependencies: 171
-- Name: detailsbrarticle_fk2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detailsbrarticle_fk2 ON detailsbrarticle USING btree (idarticle);


--
-- TOC entry 2042 (class 1259 OID 42449)
-- Dependencies: 171 171
-- Name: detailsbrarticle_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX detailsbrarticle_pk ON detailsbrarticle USING btree (idarticle, numreception);


--
-- TOC entry 2046 (class 1259 OID 42471)
-- Dependencies: 172 172
-- Name: detailsdemandearticle_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX detailsdemandearticle_pk ON detailsdemandearticle USING btree (numdemandeprix, idarticle);


--
-- TOC entry 2047 (class 1259 OID 42473)
-- Dependencies: 172
-- Name: detailsdemandeelement_fk2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detailsdemandeelement_fk2 ON detailsdemandearticle USING btree (idarticle);


--
-- TOC entry 2050 (class 1259 OID 42494)
-- Dependencies: 173
-- Name: detailsprivuser_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detailsprivuser_fk ON detailsprivuser USING btree (idpersonnel);


--
-- TOC entry 2051 (class 1259 OID 42495)
-- Dependencies: 173
-- Name: detailsprivuser_fk2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detailsprivuser_fk2 ON detailsprivuser USING btree (idpriv);


--
-- TOC entry 2052 (class 1259 OID 42493)
-- Dependencies: 173 173
-- Name: detailsprivuser_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX detailsprivuser_pk ON detailsprivuser USING btree (idpersonnel, idpriv);


--
-- TOC entry 2057 (class 1259 OID 42504)
-- Dependencies: 174 174
-- Name: detailssortiearticle_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX detailssortiearticle_pk ON detailssortiearticle USING btree (idsortie, idarticle);


--
-- TOC entry 2062 (class 1259 OID 42526)
-- Dependencies: 175 175
-- Name: detailstachepersonnel_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX detailstachepersonnel_pk ON detailstachepersonnel USING btree (numtache, idpersonnel);


--
-- TOC entry 2065 (class 1259 OID 42556)
-- Dependencies: 176
-- Name: fournisseur_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX fournisseur_pk ON fournisseur USING btree (idfournisseur);


--
-- TOC entry 2069 (class 1259 OID 42574)
-- Dependencies: 177
-- Name: personnel_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX personnel_pk ON personnel USING btree (idpersonnel);


--
-- TOC entry 2074 (class 1259 OID 42584)
-- Dependencies: 178
-- Name: privilege_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX privilege_pk ON privilege USING btree (idpriv);


--
-- TOC entry 2078 (class 1259 OID 42593)
-- Dependencies: 179
-- Name: projet_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX projet_pk ON projet USING btree (idprojet);


--
-- TOC entry 2082 (class 1259 OID 42603)
-- Dependencies: 180
-- Name: soustache_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX soustache_pk ON soustache USING btree (idsousprojet);


--
-- TOC entry 2085 (class 1259 OID 42613)
-- Dependencies: 181
-- Name: tache_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX tache_pk ON tache USING btree (numtache);


--
-- TOC entry 2086 (class 1259 OID 42614)
-- Dependencies: 181
-- Name: tacheaffaire_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX tacheaffaire_fk ON tache USING btree (idprojet);


--
-- TOC entry 2089 (class 1259 OID 42620)
-- Dependencies: 182
-- Name: typeuser_pk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX typeuser_pk ON typeuser USING btree (typeuser);


--
-- TOC entry 2092 (class 2606 OID 42621)
-- Dependencies: 2083 163 181
-- Name: fk_besoin_associati_tache; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY besoin
    ADD CONSTRAINT fk_besoin_associati_tache FOREIGN KEY (numtache) REFERENCES tache(numtache) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2094 (class 2606 OID 42631)
-- Dependencies: 2066 164 176
-- Name: fk_boncomma_associati_fourniss; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY boncommande
    ADD CONSTRAINT fk_boncomma_associati_fourniss FOREIGN KEY (idfournisseur) REFERENCES fournisseur(idfournisseur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2093 (class 2606 OID 42626)
-- Dependencies: 164 2076 179
-- Name: fk_boncomma_associati_projet; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY boncommande
    ADD CONSTRAINT fk_boncomma_associati_projet FOREIGN KEY (idprojet) REFERENCES projet(idprojet) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2095 (class 2606 OID 42636)
-- Dependencies: 2012 164 165
-- Name: fk_bonrecep_associati_boncomma; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bonreception
    ADD CONSTRAINT fk_bonrecep_associati_boncomma FOREIGN KEY (numbc) REFERENCES boncommande(numbc) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2096 (class 2606 OID 42641)
-- Dependencies: 177 166 2070
-- Name: fk_bonsorti_associati_personne; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bonsortie
    ADD CONSTRAINT fk_bonsorti_associati_personne FOREIGN KEY (idpersonnel) REFERENCES personnel(idpersonnel) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2097 (class 2606 OID 42646)
-- Dependencies: 181 2083 166
-- Name: fk_bonsorti_associati_tache; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bonsortie
    ADD CONSTRAINT fk_bonsorti_associati_tache FOREIGN KEY (numtache) REFERENCES tache(numtache) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2098 (class 2606 OID 42651)
-- Dependencies: 176 2066 168
-- Name: fk_demandep_associati_fourniss; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY demandeprix
    ADD CONSTRAINT fk_demandep_associati_fourniss FOREIGN KEY (idfournisseur) REFERENCES fournisseur(idfournisseur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2099 (class 2606 OID 42656)
-- Dependencies: 161 2000 170
-- Name: fk_detailsb_detailsbc_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailsbcarticle
    ADD CONSTRAINT fk_detailsb_detailsbc_article FOREIGN KEY (idarticle) REFERENCES article(idarticle) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2100 (class 2606 OID 42661)
-- Dependencies: 2012 170 164
-- Name: fk_detailsb_detailsbc_boncomma; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailsbcarticle
    ADD CONSTRAINT fk_detailsb_detailsbc_boncomma FOREIGN KEY (numbc) REFERENCES boncommande(numbc) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2101 (class 2606 OID 42666)
-- Dependencies: 171 2000 161
-- Name: fk_detailsb_detailsbr_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailsbrarticle
    ADD CONSTRAINT fk_detailsb_detailsbr_article FOREIGN KEY (idarticle) REFERENCES article(idarticle) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2102 (class 2606 OID 42671)
-- Dependencies: 165 171 2016
-- Name: fk_detailsb_detailsbr_bonrecep; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailsbrarticle
    ADD CONSTRAINT fk_detailsb_detailsbr_bonrecep FOREIGN KEY (numreception) REFERENCES bonreception(numreception) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2103 (class 2606 OID 42686)
-- Dependencies: 2000 172 161
-- Name: fk_detailsd_detailsde_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailsdemandearticle
    ADD CONSTRAINT fk_detailsd_detailsde_article FOREIGN KEY (idarticle) REFERENCES article(idarticle) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2104 (class 2606 OID 42691)
-- Dependencies: 172 168 2028
-- Name: fk_detailsd_detailsde_demandep; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailsdemandearticle
    ADD CONSTRAINT fk_detailsd_detailsde_demandep FOREIGN KEY (numdemandeprix) REFERENCES demandeprix(numdemandeprix) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2105 (class 2606 OID 42706)
-- Dependencies: 2070 177 173
-- Name: fk_detailsp_detailspr_personne; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailsprivuser
    ADD CONSTRAINT fk_detailsp_detailspr_personne FOREIGN KEY (idpersonnel) REFERENCES personnel(idpersonnel) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2106 (class 2606 OID 42711)
-- Dependencies: 173 178 2072
-- Name: fk_detailsp_detailspr_privileg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailsprivuser
    ADD CONSTRAINT fk_detailsp_detailspr_privileg FOREIGN KEY (idpriv) REFERENCES privilege(idpriv) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2107 (class 2606 OID 42716)
-- Dependencies: 2000 174 161
-- Name: fk_detailss_detailsbo_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailssortiearticle
    ADD CONSTRAINT fk_detailss_detailsbo_article FOREIGN KEY (idarticle) REFERENCES article(idarticle) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2108 (class 2606 OID 42721)
-- Dependencies: 166 174 2021
-- Name: fk_detailss_detailsbo_bonsorti; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailssortiearticle
    ADD CONSTRAINT fk_detailss_detailsbo_bonsorti FOREIGN KEY (idsortie) REFERENCES bonsortie(idsortie) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2109 (class 2606 OID 42736)
-- Dependencies: 177 175 2070
-- Name: fk_detailst_detailsta_personne; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailstachepersonnel
    ADD CONSTRAINT fk_detailst_detailsta_personne FOREIGN KEY (idpersonnel) REFERENCES personnel(idpersonnel) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2110 (class 2606 OID 42741)
-- Dependencies: 181 2083 175
-- Name: fk_detailst_detailsta_tache; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detailstachepersonnel
    ADD CONSTRAINT fk_detailst_detailsta_tache FOREIGN KEY (numtache) REFERENCES tache(numtache) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2111 (class 2606 OID 42751)
-- Dependencies: 177 182 2087
-- Name: fk_personne_associati_typeuser; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personnel
    ADD CONSTRAINT fk_personne_associati_typeuser FOREIGN KEY (typeuser) REFERENCES typeuser(typeuser) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2112 (class 2606 OID 42777)
-- Dependencies: 2024 179 167
-- Name: fk_projet_associati_client; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY projet
    ADD CONSTRAINT fk_projet_associati_client FOREIGN KEY (idclient) REFERENCES client(idclient) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2113 (class 2606 OID 42761)
-- Dependencies: 2083 180 181
-- Name: fk_soustach_associati_tache; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY soustache
    ADD CONSTRAINT fk_soustach_associati_tache FOREIGN KEY (numtache) REFERENCES tache(numtache) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2114 (class 2606 OID 42766)
-- Dependencies: 179 181 2076
-- Name: fk_tache_tacheaffa_projet; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tache
    ADD CONSTRAINT fk_tache_tacheaffa_projet FOREIGN KEY (idprojet) REFERENCES projet(idprojet) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2012-11-05 18:37:00 WET

--
-- PostgreSQL database dump complete
--

