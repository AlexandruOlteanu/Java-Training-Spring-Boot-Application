package db.javaschool.session_4.Problems;

public interface IShelter {
    String getName();
    float getLatitude();
    float getLongitude();
    String getOwner();
    void receiveDonation(double value);
    void spend(double value, String reason);
}
