package cse250.pa3;

import java.util.Date;

public class HealthRecord {
    private Date m_Birthday;
    private String m_ZipCode;
    private String m_BloodType;
    private boolean m_DogAllergy;
    private boolean m_CatAllergy;
    private boolean m_PeanutAllergy;
    private boolean m_GlutenAllergy;
    private BZPair m_key;

    public Date getBirthday() { return m_Birthday; }
    public String getZipCode() { return m_ZipCode; }
    public String getBloodType() { return m_BloodType; }
    public boolean getDogAllergy() { return m_DogAllergy; }
    public boolean getCatAllergy() { return m_CatAllergy; }
    public boolean getPeanutAllergy() { return m_PeanutAllergy; }
    public boolean getGlutenAllergy() { return m_GlutenAllergy; }
    public BZPair getBZPair() { return m_key; }

    public HealthRecord(Date birthday, String zipcode, String bloodtype,
                        boolean dog, boolean cat, boolean peanut, boolean gluten) {
        m_Birthday = birthday;
        m_ZipCode = zipcode;
        m_BloodType = bloodtype;
        m_DogAllergy = dog;
        m_CatAllergy = cat;
        m_PeanutAllergy = peanut;
        m_GlutenAllergy = gluten;

        m_key = new BZPair(m_Birthday, m_ZipCode);
    }

    public static enum Attribute {
        HealthRecordBloodType,
        HealthRecordAllergies;
    }
}

