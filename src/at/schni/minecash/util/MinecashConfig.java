package at.schni.minecash.util;

public class MinecashConfig {

    private FileBuilder_MC f;
    private String name = "config";
    private double base, m_c, m_uc, m_r, m_sr;

    public MinecashConfig() {
        this.f = new FileBuilder_MC("plugins//MineCash//", "config.yml");
    }

    public MinecashConfig(double base, double m_c, double m_uc, double m_r, double m_sr) {
        this.base = base;
        this.m_c = m_c;
        this.m_uc = m_uc;
        this.m_r = m_r;
        this.m_sr = m_sr;
        this.f = new FileBuilder_MC("plugins//MineCash//", "config.yml");
    }

    public FileBuilder_MC getF() {
        return this.f;
    }

    public boolean exist() {
        return f.getString(this.name) != null;
    }

    public MinecashConfig setConfig() {
        f.setValue(name + ".base", 1);
        f.setValue(name + ".multiplier.common", 0.5d);
        f.setValue(name + ".multiplier.uncommon", 1.5d);
        f.setValue(name + ".multiplier.rare", 2.0d);
        f.setValue(name + ".multiplier.superrare", 5.0d);
        f.setValue(name + ".blocks.1", "common");
        f.setValue(name + ".blocks.2", "common");
        f.setValue(name + ".blocks.3", "common");
        f.setValue(name + ".blocks.4", "common");
        f.setValue(name + ".blocks.5", "common");
        f.setValue(name + ".blocks.12", "common");
        f.setValue(name + ".blocks.13", "common");
        f.setValue(name + ".blocks.17", "common");
        f.setValue(name + ".blocks.18", "common");
        f.setValue(name + ".blocks.161", "common");
        f.setValue(name + ".blocks.162", "common");
        f.setValue(name + ".blocks.14", "uncommon");
        f.setValue(name + ".blocks.15", "uncommon");
        f.setValue(name + ".blocks.16", "uncommon");
        f.setValue(name + ".blocks.24", "uncommon");
        f.setValue(name + ".blocks.82", "uncommon");
        f.setValue(name + ".blocks.87", "uncommon");
        f.setValue(name + ".blocks.98", "uncommon");
        f.setValue(name + ".blocks.99", "uncommon");
        f.setValue(name + ".blocks.100", "uncommon");
        f.setValue(name + ".blocks.103", "uncommon");
        f.setValue(name + ".blocks.110", "uncommon");
        f.setValue(name + ".blocks.121", "uncommon");
        f.setValue(name + ".blocks.21", "rare");
        f.setValue(name + ".blocks.89", "rare");
        f.setValue(name + ".blocks.73", "rare");
        f.setValue(name + ".blocks.74", "rare");
        f.setValue(name + ".blocks.56", "superrare");
        f.setValue(name + ".blocks.129", "superrare");
        f.setValue(name + ".blocks.168", "superrare");
        f.save();
        return this;
    }

    public MinecashConfig getConfig() {
        double b = f.getDouble(name + ".base");
        double m1 = f.getDouble(name + ".multiplier.common");
        double m2 = f.getDouble(name + ".multiplier.uncommon");
        double m3 = f.getDouble(name + ".multiplier.rare");
        double m4 = f.getDouble(name + ".multiplier.superrare");
        return new MinecashConfig(b, m1, m2, m3, m4);
    }

    public double getBase() {
        return base;
    }

    public double getM_c() {
        return m_c;
    }

    public double getM_uc() {
        return m_uc;
    }

    public double getM_r() {
        return m_r;
    }

    public double getM_sr() {
        return m_sr;
    }

    public String getBlockState(String id) {
        String s = f.getString(name + ".blocks." + id);

        if (s != null) {
            return s;
        } else {
            return "null";
        }
    }
}
