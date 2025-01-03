class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    //gets the row of the position
    public int getRow() {
        return row;
    }

    //gets the column of the position
    public int getCol() {
        return col;
    }

  //used to determine if one position is equal to another
  public boolean equals(Object obj) {
    //checks if objects are the same
    if (this == obj) {
        return true;
    }
    //checks if the object doesnt exist or exists in a different class
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    //converts object to Position type
    Position otherPosition = (Position) obj;
    return this.row == otherPosition.row && this.col == otherPosition.col;
}

} //end Position