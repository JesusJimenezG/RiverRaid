package gfx;

import utils.Constants;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private Map<String, SpriteSet> units;
    private Map<String, Image> tiles;

    public SpriteLibrary() {
        units = new HashMap<>();
        tiles = new HashMap<>();
        loadUnits();
        loadTiles();
    }


    private void loadUnits() {
        String[] folderNames = getFolderNames(Constants.PATH_TO_UNITS);

        for (String folderName : folderNames) {
            SpriteSet spriteSet = new SpriteSet();
            String pathToFolder = Constants.PATH_TO_UNITS + "/" + folderName;
            String[] sheetsInFolder = getImagesInFolder(pathToFolder);

            for (String sheetName : sheetsInFolder) {
                spriteSet.addSheet(
                        sheetName.substring(0, sheetName.length() - 4),
                        ImageUtils.loadImage(pathToFolder + "/" + sheetName)
                );
            }
            units.put(folderName, spriteSet);
        }
    }
    private void loadTiles() {
        String[] imagesInFolder = getImagesInFolder(Constants.PATH_TO_TILES);

        for (String fileName : imagesInFolder) {
            tiles.put(
                    fileName.substring(0, fileName.length() - 4),
                    ImageUtils.loadImage(Constants.PATH_TO_TILES + "/" + fileName)
            );
        }
    }

    private String[] getImagesInFolder(String basePath) {
        URL resource = SpriteLibrary.class.getResource(basePath);
        assert resource != null;
        File file = new File(resource.getFile());

        return file.list((current, name) -> new File(current, name).isFile());
    }

    private String[] getFolderNames(String basePath) {
        URL resource = SpriteLibrary.class.getResource(basePath);
        assert resource != null;
        File file = new File(resource.getFile());

        return file.list((current, name) -> new File(current, name).isDirectory());
    }

    public SpriteSet getUnit(String name) {
        return units.get(name);
    }

    public Image getTile(String name){
        return tiles.get(name);
    }
}
