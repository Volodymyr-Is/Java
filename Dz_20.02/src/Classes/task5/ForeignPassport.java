package Classes.task5;

public class ForeignPassport extends Passport {
    String visaInfo;
    String foreignPassportNumber;

    public ForeignPassport(String name, String nationality, String passportNumber, String visaInfo, String foreignPassportNumber) {
        super(name, nationality, passportNumber);
        this.visaInfo = visaInfo;
        this.foreignPassportNumber = foreignPassportNumber;
    }

    public ForeignPassport(Passport passportInfo, String visaInfo, String foreignPassportNumber) {
        super(passportInfo.name, passportInfo.nationality, passportInfo.passportNumber);
        this.visaInfo = visaInfo;
        this.foreignPassportNumber = foreignPassportNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " " + visaInfo + " " + foreignPassportNumber;
    }
}
