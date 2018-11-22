package newversion;

public class TransactionNewVersion {
    String detail,type,date;
    int id;
    float amount;

    public TransactionNewVersion(int id, String detail, String type, String date, float amount) {
        this.id = id ;
        this.detail = detail;
        this.type = type;
        this.date = date;
        this.amount = amount;
    }
    public TransactionNewVersion() {
    }

    public String getId() {
        return id+"";
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount+"";
    }

    public void setAmount(String amount) {
        this.amount = Float.parseFloat(amount);
    }

    public String toStringTxtForSave(){
        return (this.id+"/"+this.type+"/"+ this.detail+"/"+this.amount+"/"+this.date);
    }

//    @Override
//    public String toString() {
//        return ("Type: "+this.type+" | Detail: "+ this.detail+" | Amount: "+this.amount+" | Date: "+this.date);
//    }
}
