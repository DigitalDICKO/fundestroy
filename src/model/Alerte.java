package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the alertes database table.
 * 
 */
@Entity
@Table(name="alertes")
@NamedQuery(name="Alerte.findAll", query="SELECT a FROM Alerte a")
public class Alerte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer idAlertes;

	@Column(nullable=false, length=120)
	private String adresse;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false, length=120)
	private String descr;

	@Column(length=30)
	private String graviteInspecteur;

	@Column(nullable=false, length=60)
	private String nature;

	@Column(nullable=false, length=30)
	private String nomRiverain;

	@Column(length=30)
	private String prioriteGestionnaire;

	@Column(nullable=false, length=30)
	private String statut;

	//bi-directional many-to-one association to Inspection
	@ManyToOne
	@JoinColumn(name="idInspections")
	private Inspection inspection;

	public Alerte() {
	}

	public Integer getIdAlertes() {
		return this.idAlertes;
	}

	public void setIdAlertes(Integer idAlertes) {
		this.idAlertes = idAlertes;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getGraviteInspecteur() {
		return this.graviteInspecteur;
	}

	public void setGraviteInspecteur(String graviteInspecteur) {
		this.graviteInspecteur = graviteInspecteur;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getNomRiverain() {
		return this.nomRiverain;
	}

	public void setNomRiverain(String nomRiverain) {
		this.nomRiverain = nomRiverain;
	}

	public String getPrioriteGestionnaire() {
		return this.prioriteGestionnaire;
	}

	public void setPrioriteGestionnaire(String prioriteGestionnaire) {
		this.prioriteGestionnaire = prioriteGestionnaire;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Inspection getInspection() {
		return this.inspection;
	}

	public void setInspection(Inspection inspection) {
		this.inspection = inspection;
	}

}