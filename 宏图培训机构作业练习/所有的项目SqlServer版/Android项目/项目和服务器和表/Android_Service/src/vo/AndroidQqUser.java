package vo;

/**
 * AndroidQqUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AndroidQqUser implements java.io.Serializable {

	// Fields

	private Long qqId;
	private String qqZhanghao;
	private String qqMima;
	private String qqTouxiang;
	private String qqName;
	private String qqMark;
	private String qqSex;
	private String qqAddress;
	private String qqPhone;
	private Long qqStatu;
	//·µ»Ø½á¹û
	private int result;


	public AndroidQqUser(Long qqId, String qqZhanghao, String qqMima, String qqTouxiang, String qqName, String qqMark,
			 String qqSex, String qqAddress,
				String qqPhone, Long qqStatu,int result) {
		super();
		this.qqId = qqId;
		this.qqZhanghao = qqZhanghao;
		this.qqMima = qqMima;
		this.qqTouxiang = qqTouxiang;
		this.qqName = qqName;
		this.qqMark = qqMark;
		this.qqSex = qqSex;
		this.qqAddress = qqAddress;
		this.qqPhone = qqPhone;
		this.qqStatu = qqStatu;
		this.result = result;
	}

	/** default constructor */
	public AndroidQqUser() {
	}

	/** minimal constructor */
	public AndroidQqUser(String qqZhanghao, String qqMima) {
		this.qqZhanghao = qqZhanghao;
		this.qqMima = qqMima;
	}

	/** full constructor */

	// Property accessors

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

	public String getQqMima() {
		return this.qqMima;
	}

	public void setQqMima(String qqMima) {
		this.qqMima = qqMima;
	}

	public String getQqTouxiang() {
		return this.qqTouxiang;
	}

	public void setQqTouxiang(String qqTouxiang) {
		this.qqTouxiang = qqTouxiang;
	}

	public String getQqName() {
		return this.qqName;
	}

	public void setQqName(String qqName) {
		this.qqName = qqName;
	}

	public String getQqMark() {
		return this.qqMark;
	}

	public void setQqMark(String qqMark) {
		this.qqMark = qqMark;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	public Long getQqStatu() {
		return this.qqStatu;
	}

	public void setQqStatu(Long qqStatu) {
		this.qqStatu = qqStatu;
	}
	public String getQqSex() {
		return this.qqSex;
	}

	public void setQqSex(String qqSex) {
		this.qqSex = qqSex;
	}

	public String getQqAddress() {
		return this.qqAddress;
	}

	public void setQqAddress(String qqAddress) {
		this.qqAddress = qqAddress;
	}

	public String getQqPhone() {
		return this.qqPhone;
	}

	public void setQqPhone(String qqPhone) {
		this.qqPhone = qqPhone;
	}
}