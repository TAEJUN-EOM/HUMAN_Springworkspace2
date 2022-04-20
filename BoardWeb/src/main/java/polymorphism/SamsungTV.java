package polymorphism;

public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price;
	
//	public SamsungTV() {
//		System.out.println("SamsungTV(1)객체생성");
//	}
//	
//	public SamsungTV(Speaker speaker) {
//		System.out.println("SamsungTV(2)객체생성");
//		this.speaker = speaker;
//	}
//	
//	public SamsungTV(Speaker speaker,int price) {
//		System.out.println("SamsungTV(3)객체생성");
//		this.speaker = speaker;
//		this.price = price;
//	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice() 호출");
		this.price = price;
	}

	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.(가격 : " + price + ")");
	}

	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}

	public void volumeUp() {
		
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("SamsungTV---소리 올린다.");
	}

	public void volumeDown() {
		//speaker = new SonySpeaker();
		speaker.volumeDown();
		//System.out.println("SamsungTV---소리 내린다.");
	}
}
