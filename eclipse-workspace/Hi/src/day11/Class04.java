package day11;

public class Class04 {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 * tv1 클래스 생성
		 * 멤버변수: brand, power, channel, volume
		 * power가 켜지면 "tv1가 켜졌습니다"
		 * 꺼지면 "tv1가 꺼졌습니다"
		 * 
		 * 메소드: power(), channelUp() => 채널이 1씩 증가 채널은 20번까지 있음
		 * 채널이 20을 넘어가면 다시 1번부터 시작
		 * channelDown() => 1씩 감소 채널이 0을 넘어가면 20번부터 다시 시작
		 * 
		 * volumeUp/Down =>1씩 증가, 1씩 감수
		 * 볼륨은 10까지 있음. 10이 넘으면 계속 10, 0에서 계속 내리면 음소거 출력
		 * 
		 */
		        Tv tv = new Tv();
		        
		         

		        tv.print();
		        tv.power(); 
		        System.out.println("티비 전원: "+(tv.isPower()? "On":"Off"));
		        tv.volumeUp();
		        tv.volumeUp();
		        tv.volumeUp();
		        tv.volumeUp();
		        tv.volumeUp();
		        tv.volumeUp();
		        tv.volumeUp();
		        tv.volumeUp();
		        tv.volumeUp();
		        tv.volumeUp();
		        tv.volumeUp();
		        
		        System.out.println("티비 볼륨:"+tv.getvolume());
		        tv.power();
		        
		        tv.volumeDown();
		        tv.volumeDown();
		        tv.volumeDown();
		        tv.volumeDown();
		        tv.volumeDown();
		        tv.volumeDown();
		        tv.volumeDown();
		        tv.volumeDown();
		        tv.volumeDown();
		        tv.volumeDown();
		        tv.volumeDown();
		        
		        
		        
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        tv.channelUp();
		        
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        
		        tv.channelDown();
		        
		        tv.channelDown();
		        tv.channelDown();
		        
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        
		        tv.channelDown();
		        
		        tv.channelDown();
		        tv.channelDown();
		        
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        tv.channelDown();
		        
		        tv.channelDown();
		        
		        
		        
		    }
		}

		class Tv {
		    private final String BRAND = "LG";
		    
		    private boolean power;
		    private int channel;
		    private int volume;

		    public void power() {
		        if (!power && volume == 0) {
		            power = true;
		            System.out.println("티비가 켜졌습니다.");
		        } else if (power && volume == -10) {
		            power = false;
		            System.out.println("티비가 꺼졌습니다."+ volume);
		        } 
		    }

		    public void volumeUp() {
		        if (!power) {
		            System.out.println("티비 꺼져있으니 켜세요");
		            return;
		        }

		        if (volume >= 10) {
		            System.out.println("현재 최고 볼륨입니다.");
		        } else {
		            volume += 1;
		            System.out.println("현재 볼륨: " + volume);
		        }
		    }

		    public void volumeDown() {
		        if (!power) {
		            System.out.println("티비가 꺼져있습니다. 티비 켜주세요.");
		            return;
		        }
		        if (volume <= 0) {
		            volume = 0;
		            System.out.println("음소거입니다.");
		        } 
		        else {
		            volume -= 1;
		            System.out.println("현재 볼륨: " + volume);
		        }
		    }
		    
		    public void channelUp() {
		        if (!power) {
		            System.out.println("티비가 꺼져있습니다. 티비 켜주세요.");
		            return;
		        }

		        if (channel >= 20) {
		            channel = 0;
		            System.out.println("현재 채널: " + channel);
		            
		        } else {
		            channel += 1;
		            System.out.println("현재 채널: " + channel);
		        }
		    }
		    
		    public void channelDown() {
		        if (!power) {
		            System.out.println("티비가 꺼져있습니다. 티비 켜주세요.");
		            return;
		        }

		        if (channel <= 0) {
		            channel = 20;
		            System.out.println("현재 채널: " + channel);
		            
		        } else {
		            channel -= 1;
		            System.out.println("현재 채널: " + channel);
		        }
		    }

		    public void print() {
		        System.out.println("Tv: "+BRAND);
		    }

		    
			
			public boolean isPower() {
				return power;
			}
			
			public void setPower(boolean power) {
				this.power = power;
			}
			
			public int getvolume() {
				return volume;
			}
			
			public void setvolume(int volume) {
				this.volume = volume;
			}
			public int getchannel() {
				return channel;
			}
			
			public void setchannel(int channel) {
				this.channel = channel;
			}
			

		    
		}
		
