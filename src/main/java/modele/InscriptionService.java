package modele;

public class InscriptionService {

    public Inscription inscrire(String fname, String lname, String civility, String urgent) throws InscriptionExecption {
        InscriptionExecption ex = new InscriptionExecption();
        if (fname.isEmpty()) {
            ex.addMessage("fname", "First Name est invalide !");
        }
        if (lname.isEmpty()) {
            ex.addMessage("lname", "Last Name est invalide !");
        }
        if (ex.mustBeThrown()) {
            throw ex;
        }

        return new Inscription(fname, lname, civility, urgent);
    }

}