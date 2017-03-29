package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the inspections database table.
 * 
 */
@Entity
@Table(name="inspections")
@NamedQuery(name="Inspection.findAll", query="SELECT i FROM Inspection i")
public class Inspection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer idInspections;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Temporal(TemporalType.DATE)
	private Date dateCR;

	@Column(nullable=false, length=120)
	private String descrCR;

	private Integer idCR;

	private Integer idUser;

	@Column(nullable=false, length=60)
	private String statutInspections;

	@Column(length=60)
	private String travauxCR;

	//bi-directional many-to-one association to Alerte
	@OneToMany(mappedBy="inspection")
	private List<Alerte> alertes;

	public Inspection() {
	}

	public Integer getIdInspections() {
		return this.idInspections;
	}

	public void setIdInspections(Integer idInspections) {
		this.idInspections = idInspections;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateCR() {
		return this.dateCR;
	}

	public void setDateCR(Date dateCR) {
		this.dateCR = dateCR;
	}

	public String getDescrCR() {
		return this.descrCR;
	}

	public void setDescrCR(String descrCR) {
		this.descrCR = descrCR;
	}

	public Integer getIdCR() {
		return this.idCR;
	}

	public void setIdCR(Integer idCR) {
		this.idCR = idCR;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getStatutInspections() {
		return this.statutInspections;
	}

	public void setStatutInspections(String statutInspections) {
		this.statutInspections = statutInspections;
	}

	public String getTravauxCR() {
		return this.travauxCR;
	}

	public void setTravauxCR(String travauxCR) {
		this.travauxCR = travauxCR;
	}

	public List<Alerte> getAlertes() {
		return this.alertes;
	}

	public void setAlertes(List<Alerte> alertes) {
		this.alertes = alertes;
	}

	public Alerte addAlerte(Alerte alerte) {
		getAlertes().add(alerte);
		alerte.setInspection(this);

		return alerte;
	}

	public Alerte removeAlerte(Alerte alerte) {
		getAlertes().remove(alerte);
		alerte.setInspection(null);

		return alerte;
	}

}