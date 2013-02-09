create table Article (
   idArticle            VARCHAR(254)         not null,
   descArticle          VARCHAR(254)         null,
   qntArticle           INT4                 null,
   marque               VARCHAR(254)         null,
   refCommerciale       VARCHAR(254)         null,
   refCommande          VARCHAR(254)         null,
   unite                VARCHAR(254)         null,
   categorie            VARCHAR(254)         null,
   constraint PK_ARTICLE primary key (idArticle)
);

create unique index ARTICLE_PK on Article (
idArticle
);

create table Audit (
   idAudit              VARCHAR(254)         not null,
   typeOperation        VARCHAR(254)         null,
   userId               VARCHAR(254)         null,
   userName             VARCHAR(254)         null,
   typeModification     VARCHAR(254)         null,
   dateAudit            DATE                 null,
   heurAudit            INT4                 null,
   constraint PK_AUDIT primary key (idAudit)
);

create unique index AUDIT_PK on Audit (
idAudit
);

create table Besoin (
   idBesoin             VARCHAR(254)         not null,
   numTache             VARCHAR(254)         not null,
   dateBesoin           DATE                 null,
   descBesoin           VARCHAR(254)         null,
   constraint PK_BESOIN primary key (idBesoin)
);

create unique index BESOIN_PK on Besoin (
idBesoin
);

create  index ASSOCIATION5_FK on Besoin (
numTache
);

create table BonCommande (
   numBc                VARCHAR(254)         not null,
   idFournisseur        VARCHAR(254)         not null,
   idProjet             VARCHAR(254)         not null,
   dateBonCommande      DATE                 null,
   prixHt               NUMERIC              null,
   constraint PK_BONCOMMANDE primary key (numBc)
);

create unique index BONCOMMANDE_PK on BonCommande (
numBc
);

create  index ASSOCIATION9_FK on BonCommande (
idFournisseur
);

create  index ASSOCIATION21_FK on BonCommande (
idProjet
);

create table BonReception (
   numReception         VARCHAR(254)         not null,
   numBc                VARCHAR(254)         not null,
   dateReception        DATE                 null,
   constraint PK_BONRECEPTION primary key (numReception)
);

create unique index BONRECEPTION_PK on BonReception (
numReception
);

create  index ASSOCIATION10_FK on BonReception (
numBc
);

create table BonSortie (
   idSortie             VARCHAR(254)         not null,
   numTache             VARCHAR(254)         not null,
   idPersonnel          VARCHAR(254)         not null,
   dateSortie           DATE                 null,
   descSortie           VARCHAR(254)         null,
   constraint PK_BONSORTIE primary key (idSortie)
);

create unique index BONSORTIE_PK on BonSortie (
idSortie
);

create  index ASSOCIATION14_FK on BonSortie (
idPersonnel
);

create  index ASSOCIATION19_FK on BonSortie (
numTache
);

create table Client (
   idClient             VARCHAR(254)         not null,
   nomClient            VARCHAR(254)         null,
   email                VARCHAR(254)         null,
   tel                  VARCHAR(254)         null,
   fax                  VARCHAR(254)         null,
   adresse              VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   constraint PK_CLIENT primary key (idClient)
);
create unique index CLIENT_PK on Client (
idClient
);

create table DemandePrix (
   numDemandePrix       VARCHAR(254)         not null,
   idFournisseur        VARCHAR(254)         not null,
   referenceDemandePrix VARCHAR(254)         null,
   dateDemandePrix      DATE                 null,
   constraint PK_DEMANDEPRIX primary key (numDemandePrix)
);

create unique index DEMANDEPRIX_PK on DemandePrix (
numDemandePrix
);

create  index ASSOCIATION23_FK on DemandePrix (
idFournisseur
);

create table DetailsArticlBesoin (
   idBesoin             VARCHAR(254)         not null,
   idArticle            VARCHAR(254)         not null,
   qntBesoin            INT4                 null,
   constraint PK_DETAILSARTICLBESOIN primary key (idBesoin, idArticle)
);

create unique index DETAILSARTICLBESOIN_PK on DetailsArticlBesoin (
idBesoin,
idArticle
);

create  index DETAILSARTICLEBESOIN_FK on DetailsArticlBesoin (
idBesoin
);

create  index DETAILSARTICLEBESOIN_FK2 on DetailsArticlBesoin (
idArticle
);

create table DetailsBcArticle (
   numBc                VARCHAR(254)         not null,
   idArticle            VARCHAR(254)         not null,
   qntCommande          INT4                 null,
   prixUnitaire         NUMERIC              null,
   qntlivre             INT4                 null,
   constraint PK_DETAILSBCARTICLE primary key (numBc, idArticle)
);

create unique index DETAILSBCARTICLE_PK on DetailsBcArticle (
numBc,
idArticle
);

create  index ASSOCIATION11_FK on DetailsBcArticle (
numBc
);

create  index DETAILSBCARTICLE_FK2 on DetailsBcArticle (
idArticle
);

create table DetailsBcFourniture (
   numBc                VARCHAR(254)         not null,
   numFourniture        VARCHAR(254)         not null,
   qntCommande          INT4                 null,
   prixUnitaire         NUMERIC              null,
   qntlivre             INT4                 null,
   constraint PK_DETAILSBCFOURNITURE primary key (numBc, numFourniture)
);

create unique index DETAILSBCFOURNITURE_PK on DetailsBcFourniture (
numBc,
numFourniture
);

create  index DETAILSBCFOURNITURE_FK on DetailsBcFourniture (
numBc
);

create  index DETAILSBCFOURNITURE_FK2 on DetailsBcFourniture (
numFourniture
);

create table DetailsBrArticle (
   idArticle            VARCHAR(254)         not null,
   numReception         VARCHAR(254)         not null,
   qntLivre             INT4                 null,
   constraint PK_DETAILSBRARTICLE primary key (idArticle, numReception)
);

create unique index DETAILSBRARTICLE_PK on DetailsBrArticle (
idArticle,
numReception
);

create  index ASSOCIATION12_FK on DetailsBrArticle (
numReception
);

create  index DETAILSBRARTICLE_FK2 on DetailsBrArticle (
idArticle
);

create table DetailsBrFourniture (
   numFourniture        VARCHAR(254)         not null,
   numReception         VARCHAR(254)         not null,
   qntLivre             INT4                 null,
   constraint PK_DETAILSBRFOURNITURE primary key (numFourniture, numReception)
);

create unique index DETAILSBRFOURNITURE_PK on DetailsBrFourniture (
numFourniture,
numReception
);

create  index DETAILSBRFOURNITURE_FK on DetailsBrFourniture (
numFourniture
);

create  index DETAILSBRFOURNITURE_FK2 on DetailsBrFourniture (
numReception
);

create table DetailsDemandeArticle (
   numDemandePrix       VARCHAR(254)         not null,
   idArticle            VARCHAR(254)         not null,
   qntDemande           INT4                 null,
   constraint PK_DETAILSDEMANDEARTICLE primary key (numDemandePrix, idArticle)
);

create unique index DETAILSDEMANDEARTICLE_PK on DetailsDemandeArticle (
numDemandePrix,
idArticle
);

create  index ASSOCIATION8_FK on DetailsDemandeArticle (
numDemandePrix
);

create  index DETAILSDEMANDEELEMENT_FK2 on DetailsDemandeArticle (
idArticle
);

create table DetailsFournitureBesoin (
   idBesoin             VARCHAR(254)         not null,
   numFourniture        VARCHAR(254)         not null,
   qntBesoin            INT4                 null,
   constraint PK_DETAILSFOURNITUREBESOIN primary key (idBesoin, numFourniture)
);

create unique index DETAILSFOURNITUREBESOIN_PK on DetailsFournitureBesoin (
idBesoin,
numFourniture
);

create  index ASSOCIATION24_FK on DetailsFournitureBesoin (
idBesoin
);

create  index ASSOCIATION24_FK2 on DetailsFournitureBesoin (
numFourniture
);

create table DetailsPrivUser (
   idPersonnel          VARCHAR(254)         not null,
   idPriv               VARCHAR(254)         not null,
   description          VARCHAR(254)         null,
   constraint PK_DETAILSPRIVUSER primary key (idPersonnel, idPriv)
);

create unique index DETAILSPRIVUSER_PK on DetailsPrivUser (
idPersonnel,
idPriv
);

create  index DETAILSPRIVUSER_FK on DetailsPrivUser (
idPersonnel
);

create  index DETAILSPRIVUSER_FK2 on DetailsPrivUser (
idPriv
);

create table DetailsSortieArticle (
   idSortie             VARCHAR(254)         not null,
   idArticle            VARCHAR(254)         not null,
   qntSortie            INT4                 null,
   qntRetour            INT4                 null,
   constraint PK_DETAILSSORTIEARTICLE primary key (idSortie, idArticle)
);

create unique index DETAILSSORTIEARTICLE_PK on DetailsSortieArticle (
idSortie,
idArticle
);
create  index ASSOCIATION13_FK on DetailsSortieArticle (
idSortie
);

create  index DETAILSBONSORTIEELEMENT_FK2 on DetailsSortieArticle (
idArticle
);

create table DetailsSortieFourniture (
   idSortie             VARCHAR(254)         not null,
   numFourniture        VARCHAR(254)         not null,
   qntSortie            INT4                 null,
   qntRetour            INT4                 null,
   constraint PK_DETAILSSORTIEFOURNITURE primary key (idSortie, numFourniture)
);

create unique index DETAILSSORTIEFOURNITURE_PK on DetailsSortieFourniture (
idSortie,
numFourniture
);

create  index DETAILSSORTIEFOURNITURE_FK on DetailsSortieFourniture (
idSortie
);

create  index DETAILSSORTIEFOURNITURE_FK2 on DetailsSortieFourniture (
numFourniture
);

create table DetailsTachePersonnel (
   numTache             VARCHAR(254)         not null,
   idPersonnel          VARCHAR(254)         not null,
   dateDebut            DATE                 null,
   dateFin              DATE                 null,
   constraint PK_DETAILSTACHEPERSONNEL primary key (numTache, idPersonnel)
);

create unique index DETAILSTACHEPERSONNEL_PK on DetailsTachePersonnel (
numTache,
idPersonnel
);

create  index ASSOCIATION18_FK on DetailsTachePersonnel (
numTache
);

create  index ASSOCIATION18_FK2 on DetailsTachePersonnel (
idPersonnel
);

create table Devis (
   numDevis             VARCHAR(254)         not null,
   idProjet             VARCHAR(254)         not null,
   dateDevis            DATE                 null,
   lienDevis            VARCHAR(254)         null,
   montantDevis         NUMERIC              null,
   descDevis            VARCHAR(254)         null,
   constraint PK_DEVIS primary key (numDevis)
);

create unique index DEVIS_PK on Devis (
numDevis
);

create table Facture (
   numFacture           VARCHAR(254)         not null,
   idProjet             VARCHAR(254)         not null,
   dateFacture          DATE                 null,
   descFacture          VARCHAR(254)         null,
   montantFacture       NUMERIC              null,
   lienFacture          VARCHAR(254)         null,
   constraint PK_FACTURE primary key (numFacture)
);

create unique index FACTEUR_PK on Facture (
numFacture
);

create  index ASSOCIATION4_FK on Facture (
idProjet
);
create table Fournisseur (
   idFournisseur        VARCHAR(254)         not null,
   nom                  VARCHAR(254)         null,
   email                VARCHAR(254)         null,
   tel                  VARCHAR(254)         null,
   fax                  VARCHAR(254)         null,
   adresse              VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   constraint PK_FOURNISSEUR primary key (idFournisseur)
);

create unique index FOURNISSEUR_PK on Fournisseur (
idFournisseur
);

create table Fourniture (
   numFourniture        VARCHAR(254)         not null,
   descFourniture       VARCHAR(254)         null,
   qntFourniture        INT4                 null,
   constraint PK_FOURNITURE primary key (numFourniture)
);

create unique index FOURNITURE_PK on Fourniture (
numFourniture
);

create table Personnel (
   idPersonnel          VARCHAR(254)         not null,
   typeUser             INT4                 not null,
   nom                  VARCHAR(254)         null,
   prenom               VARCHAR(254)         null,
   dateNaissance        DATE                 null,
   adresse              VARCHAR(254)         null,
   tel                  VARCHAR(254)         null,
   email                VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   fonction             VARCHAR(254)         null,
   password             VARCHAR(254)         null,
   constraint PK_PERSONNEL primary key (idPersonnel)
);

create unique index PERSONNEL_PK on Personnel (
idPersonnel
);

create  index ASSOCIATION20_FK on Personnel (
typeUser
);

create table Privilege (
   idPriv               VARCHAR(254)         not null,
   lienPriv             VARCHAR(254)         null,
   nomPriv              VARCHAR(254)         null,
   constraint PK_PRIVILEGE primary key (idPriv)
);

create unique index PRIVILEGE_PK on Privilege (
idPriv
);

create table Projet (
   idProjet             VARCHAR(254)         not null,
   idClient             VARCHAR(254)         not null,
   dateDebutAffaire     DATE                 null,
   dateFinAffaire       DATE                 null,
   descProjet           VARCHAR(254)         null,
   montantAffaire       NUMERIC              null,
   dateIntervention     DATE                 null,
   lieuIntervention     VARCHAR(254)         null,
   typeProjet           VARCHAR(254)         null,
   constraint PK_PROJET primary key (idProjet)
);

create unique index PROJET_PK on Projet (
idProjet
);

create  index ASSOCIATION22_FK on Projet (
idClient
);

create table SousTache (
   idSousprojet         VARCHAR(254)         not null,
   numTache             VARCHAR(254)         not null,
   descSousprojet       VARCHAR(254)         null,
   constraint PK_SOUSTACHE primary key (idSousprojet)
);

create unique index SOUSTACHE_PK on SousTache (
idSousprojet
);

create  index ASSOCIATION25_FK on SousTache (
numTache
);

create table Tache (
   numTache             VARCHAR(254)         not null,
   idProjet             VARCHAR(254)         not null,
   designationTache     VARCHAR(254)         null,
   dureFabrication      INT4                 null,
   lienImplementation   VARCHAR(254)         null,
   lienSchema           VARCHAR(254)         null,
   lieuTache            VARCHAR(254)         null,
   typeTache            VARCHAR(254)         null,
   constraint PK_TACHE primary key (numTache)
);

create unique index TACHE_PK on Tache (
numTache
);

create  index TACHEAFFAIRE_FK on Tache (
idProjet
);

create table TypeUser (
   typeUser             INT4                 not null,
   nomPriv              VARCHAR(254)         null,
   constraint PK_TYPEUSER primary key (typeUser)
);

create unique index TYPEUSER_PK on TypeUser (
typeUser
);

alter table Besoin
   add constraint FK_BESOIN_ASSOCIATI_TACHE foreign key (numTache)
      references Tache (numTache)
      on delete restrict on update restrict;

alter table BonCommande
   add constraint FK_BONCOMMA_ASSOCIATI_PROJET foreign key (idProjet)
      references Projet (idProjet)
      on delete restrict on update restrict;

alter table BonCommande
   add constraint FK_BONCOMMA_ASSOCIATI_FOURNISS foreign key (idFournisseur)
      references Fournisseur (idFournisseur)
      on delete restrict on update restrict;

alter table BonReception
   add constraint FK_BONRECEP_ASSOCIATI_BONCOMMA foreign key (numBc)
      references BonCommande (numBc)
      on delete restrict on update restrict;

alter table BonSortie
   add constraint FK_BONSORTI_ASSOCIATI_PERSONNE foreign key (idPersonnel)
      references Personnel (idPersonnel)
      on delete restrict on update restrict;

alter table BonSortie
   add constraint FK_BONSORTI_ASSOCIATI_TACHE foreign key (numTache)
      references Tache (numTache)
      on delete restrict on update restrict;

alter table DemandePrix
   add constraint FK_DEMANDEP_ASSOCIATI_FOURNISS foreign key (idFournisseur)
      references Fournisseur (idFournisseur)
      on delete restrict on update restrict;

alter table DetailsBcArticle
   add constraint FK_DETAILSB_DETAILSBC_ARTICLE foreign key (idArticle)
      references Article (idArticle)
      on delete restrict on update restrict;

alter table DetailsBcArticle
   add constraint FK_DETAILSB_DETAILSBC_BONCOMMA foreign key (numBc)
      references BonCommande (numBc)
      on delete restrict on update restrict;

alter table DetailsBrArticle
   add constraint FK_DETAILSB_DETAILSBR_ARTICLE foreign key (idArticle)
      references Article (idArticle)
      on delete restrict on update restrict;

alter table DetailsBrArticle
   add constraint FK_DETAILSB_DETAILSBR_BONRECEP foreign key (numReception)
      references BonReception (numReception)
      on delete restrict on update restrict;

alter table DetailsBrFourniture
   add constraint FK_DETAILSB_DETAILSBR_BONRECEP foreign key (numReception)
      references BonReception (numReception)
      on delete restrict on update restrict;

alter table DetailsBrFourniture
   add constraint FK_DETAILSB_DETAILSBR_FOURNITU foreign key (numFourniture)
      references Fourniture (numFourniture)
      on delete restrict on update restrict;

alter table DetailsDemandeArticle
   add constraint FK_DETAILSD_DETAILSDE_ARTICLE foreign key (idArticle)
      references Article (idArticle)
      on delete restrict on update restrict;

alter table DetailsDemandeArticle
   add constraint FK_DETAILSD_DETAILSDE_DEMANDEP foreign key (numDemandePrix)
      references DemandePrix (numDemandePrix)
      on delete restrict on update restrict;

alter table DetailsFournitureBesoin
   add constraint FK_DETAILSF_ASSOCIATI_BESOIN foreign key (idBesoin)
      references Besoin (idBesoin)
      on delete restrict on update restrict;

alter table DetailsFournitureBesoin
   add constraint FK_DETAILSF_ASSOCIATI_FOURNITU foreign key (numFourniture)
      references Fourniture (numFourniture)
      on delete restrict on update restrict;

alter table DetailsPrivUser
   add constraint FK_DETAILSP_DETAILSPR_PERSONNE foreign key (idPersonnel)
      references Personnel (idPersonnel)
      on delete restrict on update restrict;

alter table DetailsPrivUser
   add constraint FK_DETAILSP_DETAILSPR_PRIVILEG foreign key (idPriv)
      references Privilege (idPriv)
      on delete restrict on update restrict;

alter table DetailsSortieArticle
   add constraint FK_DETAILSS_DETAILSBO_ARTICLE foreign key (idArticle)
      references Article (idArticle)
      on delete restrict on update restrict;

alter table DetailsSortieArticle
   add constraint FK_DETAILSS_DETAILSBO_BONSORTI foreign key (idSortie)
      references BonSortie (idSortie)
      on delete restrict on update restrict;

alter table DetailsSortieFourniture
   add constraint FK_DETAILSS_DETAILSSO_BONSORTI foreign key (idSortie)
      references BonSortie (idSortie)
      on delete restrict on update restrict;

alter table DetailsSortieFourniture
   add constraint FK_DETAILSS_DETAILSSO_FOURNITU foreign key (numFourniture)
      references Fourniture (numFourniture)
      on delete restrict on update restrict;

alter table DetailsTachePersonnel
   add constraint FK_DETAILST_DETAILSTA_PERSONNE foreign key (idPersonnel)
      references Personnel (idPersonnel)
      on delete restrict on update restrict;

alter table DetailsTachePersonnel
   add constraint FK_DETAILST_DETAILSTA_TACHE foreign key (numTache)
      references Tache (numTache)
      on delete restrict on update restrict;

alter table Facture
   add constraint FK_FACTURE_ASSOCIATI_PROJET foreign key (idProjet)
      references Projet (idProjet)
      on delete restrict on update restrict;

alter table Personnel
   add constraint FK_PERSONNE_ASSOCIATI_TYPEUSER foreign key (typeUser)
      references TypeUser (typeUser)
      on delete restrict on update restrict;

alter table Projet
   add constraint FK_PROJET_ASSOCIATI_CLIENT foreign key (idClient)
      references Client (idClient)
      on delete restrict on update restrict;

alter table SousTache
   add constraint FK_SOUSTACH_ASSOCIATI_TACHE foreign key (numTache)
      references Tache (numTache)
      on delete restrict on update restrict;

alter table Tache
   add constraint FK_TACHE_TACHEAFFA_PROJET foreign key (idProjet)
      references Projet (idProjet)
      on delete restrict on update restrict;

