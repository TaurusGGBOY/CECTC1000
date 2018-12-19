package ggb.s8.bll;

public class MessageInterpreter {

	public String[] msg;
	private String sourid;
	private String destid;
	private String time;
	private String content;

	public MessageInterpreter(String msgString) {
		// TODO Auto-generated constructor stub
		msg = msgString.split(" ");
		sourid = msg[0];
		destid = msg[1];
		time = msg[2];
		content = msg[3];
	}

	public String getSourceid() {
		return sourid;
	}

	public String getDestid() {
		return destid;
	}

	public String getTime() {
		return time;
	}

	public String getContent() {
		return content;
	}
}
