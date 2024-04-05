package day15;

public class Customer {
    public int customerId;
    public String customerName;
    public String customerGrade;
    public int bonusPoint;
    public double bonusRatio;
    public int consultantId;

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerGrade = "Silver";
        this.bonusRatio = 0.01;
    }

    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price;
    }

    public String customerInfo() {
        return customerName + "님의 등급은 " + customerGrade + "이고, 보너스 포인트는 " + bonusPoint + "입니다.";
    }

	public int getBonusPoint() {
		// TODO Auto-generated method stub
		return bonusPoint;
	}

    
}

class GoldCustomer extends Customer {
    public GoldCustomer(int customerId, String customerName) {
        super(customerId, customerName);
        this.customerGrade = "Gold";
        this.bonusRatio = 0.02;
    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price - (int)(price * 0.1);
    }
}

class VipCustomer extends Customer {
    

    public VipCustomer(int customerId, String customerName, int agentId) {
        super(customerId, customerName);
        this.customerGrade = "Vip";
        this.bonusRatio = 0.05;
        this.consultantId = consultantId;
    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price - (int)(price * 0.1);
    }

    @Override
    public String customerInfo() {
        return super.customerInfo() + "담당 상담원 아이디는 " + consultantId + "입니다.";
    }

    public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	
}


	


	
