package ph.edu.dlsu;

public class IDoctor extends IWorker {
    @Override
    public String DisplayName(String name) {
        return name;
    }

    @Override
    public String DisplayCompany(String company) {
        return company;
    }
}