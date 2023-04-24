package br.com.anderson;

public class Saudacao {
	
	private final long id;
	private final String contentString;
	
	public Saudacao(long id, String content) {
		this.id = id;
		this.contentString = content;
	}

	public long getId() {
		return id;
	}

	public String getContentString() {
		return contentString;
	}
	
	
	

}
