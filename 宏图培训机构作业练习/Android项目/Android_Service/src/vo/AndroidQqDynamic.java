package vo;

/**
 * AndroidQqDynamic entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AndroidQqDynamic implements java.io.Serializable {

	// Fields

	private Long dyId;
	private Long qqId;
	private String qqZhanghao;
	private String qqName;
	private String qqTouxiang;
	private String dyDate;
	private String dyContent;
	private String dyPhotos;

	// Constructors

	/** default constructor */
	public AndroidQqDynamic() {
	}

	/** full constructor */
	public AndroidQqDynamic(Long qqId, String qqZhanghao, String qqName,
			String qqTouxiang, String dyDate, String dyContent, String dyPhotos) {
		this.qqId = qqId;
		this.qqZhanghao = qqZhanghao;
		this.qqName = qqName;
		this.qqTouxiang = qqTouxiang;
		this.dyDate = dyDate;
		this.dyContent = dyContent;
		this.dyPhotos = dyPhotos;
	}

	// Property accessors

	public Long getDyId() {
		return this.dyId;
	}

	public void setDyId(Long dyId) {
		this.dyId = dyId;
	}

	public Long getQqId() {
		return this.qqId;
	}

	public void setQqId(Long qqId) {
		this.qqId = qqId;
	}

	public String getQqZhanghao() {
		return this.qqZhanghao;
	}

	public void setQqZhanghao(String qqZhanghao) {
		this.qqZhanghao = qqZhanghao;
	}

	public String getQqName() {
		return this.qqName;
	}

	public void setQqName(String qqName) {
		this.qqName = qqName;
	}

	public String getQqTouxiang() {
		return this.qqTouxiang;
	}

	public void setQqTouxiang(String qqTouxiang) {
		this.qqTouxiang = qqTouxiang;
	}

	public String getDyDate() {
		return this.dyDate;
	}

	public void setDyDate(String dyDate) {
		this.dyDate = dyDate;
	}

	public String getDyContent() {
		return this.dyContent;
	}

	public void setDyContent(String dyContent) {
		this.dyContent = dyContent;
	}

	public String getDyPhotos() {
		return this.dyPhotos;
	}

	public void setDyPhotos(String dyPhotos) {
		this.dyPhotos = dyPhotos;
	}

}