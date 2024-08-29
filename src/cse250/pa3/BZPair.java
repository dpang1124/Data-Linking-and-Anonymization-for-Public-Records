package cse250.pa3;

import java.util.Date;
import java.util.Objects;

/**
 * A class representing a hashable pair of Birthday and Zipcode
 */
public class BZPair {
    private Date m_birthday;
    private String m_zipcode;

    public BZPair(Date bd, String z) {
        m_birthday = bd;
        m_zipcode = z;
    }

    public Date getBirthday() { return m_birthday; }
    public String getZipcode() { return m_zipcode; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BZPair bzPair = (BZPair) o;
        return Objects.equals(m_birthday, bzPair.m_birthday) && Objects.equals(m_zipcode, bzPair.m_zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_birthday, m_zipcode);
    }
}
