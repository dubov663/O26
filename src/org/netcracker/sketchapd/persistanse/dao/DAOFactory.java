package org.netcracker.sketchapd.persistanse.dao;

public abstract class DAOFactory {

    private static DAOFactory instance;

    protected DAOFactory() {}

    public static DAOFactory getInstance () {
        if (instance == null) {
            //instance = new JDBCDAOFactory();
        }
        return instance;
    }

    /**
     * Returns NoteDAO
     *
     * @return {@link NoteDAO}
     */
    public abstract NoteDAO getNoteDAO();

    /**
     * Returns SketchpadDAO
     *
     * @return {@link SketchpadDAO}
     */
    public abstract SketchpadDAO getSketchpadDAO();
}
