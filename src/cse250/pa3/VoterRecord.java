package cse250.pa3;

import java.util.Date;

public class VoterRecord {
    private String m_FirstName;
    private String m_LastName;
    private Date m_Birthday;
    private String m_ZipCode;
    private BZPair m_key;

    public String getFirstName() { return m_FirstName; }
    public String getLastName() { return m_LastName; }
    public String getFullName() {
        return m_FirstName + " " + m_LastName;
    }
    public Date getBirthday() { return m_Birthday; }
    public String getZipCode() { return m_ZipCode; }
    public BZPair getBZPair() { return m_key; }

    public VoterRecord(String first, String last, Date birthday, String zipcode) {
        m_FirstName = first;
        m_LastName = last;
        m_Birthday = birthday;
        m_ZipCode = zipcode;

        m_key = new BZPair(birthday, zipcode);
    }
}
