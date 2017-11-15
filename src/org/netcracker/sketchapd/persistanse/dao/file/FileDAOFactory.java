package org.netcracker.sketchapd.persistanse.dao.file;

import org.netcracker.sketchapd.persistanse.dao.DAOFactory;
import org.netcracker.sketchapd.persistanse.dao.NoteDAO;
import org.netcracker.sketchapd.persistanse.dao.SketchpadDAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDAOFactory extends DAOFactory {
    private List<String> contents;
    private List<Note> notes;
    private Path path = Paths.get("D://NetCracker//Ovsyannikov//Project//files");


    public FileDAOFactory() {
        List<String> contentsForNote = null;
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(path);
            FileInputStream fstream = new FileInputStream("content.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            for (Path ds : stream) {
                BufferedReader reader = Files.newBufferedReader(ds);
                while(reader.readLine() != null) {
                    contentsForNote.add(reader.readLine());
                }
                //notes.add(contentsForNote);
            }


            while(br.readLine() != null) {
                contents.add(br.readLine());
            }
            br.close();
            fstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NoteDAO getNoteDAO() {
        return /*new JDBCNoteDAO(contents)*/ null;
    }

    @Override
    public SketchpadDAO getSketchpadDAO() {
        return /*new JDBCSketchpadDAO(notes)*/ null;
    }
}
