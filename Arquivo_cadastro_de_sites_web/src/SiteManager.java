import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class SiteManager {
    private File directory;
    private int nextId = 0;

    public SiteManager(String directoryPath) {
        this.directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        this.nextId = determineNextId();
    }

    private int determineNextId() {
        // Esta função assume que os IDs são sequenciais e determina o próximo ID a ser usado
        String[] files = directory.list();
        int maxId = 0;
        for (String file : files) {
            if (file.endsWith(".data")) {
                int id = Integer.parseInt(file.replace(".data", ""));
                if (id > maxId) maxId = id;
            }
        }
        return maxId + 1;
    }

    public int saveSite(Site site) throws IOException {
        String fileName = nextId + ".data";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(directory, fileName)));
        oos.writeObject(site);
        oos.close();
        return nextId++;
    }

    public Site loadSite(int id) throws IOException, ClassNotFoundException {
        String fileName = id + ".data";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(directory, fileName)));
        Site site = (Site) ois.readObject();
        ois.close();
        return site;
    }
}