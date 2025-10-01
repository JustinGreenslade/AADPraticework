package QAPs.TheaterQAP1;

public class SeatingChart {
 private char[][] seats;

  public SeatingChart(int row, int col){
      seats = new char[row][col];
      addEmptySeats();
  }

  // Fills seats with the char O to show it's an Open/Not booked seat
  public void addEmptySeats(){
      for (int row = 0; row < seats.length; row++){
          for (int col = 0; col < seats.length; col++){
              seats[col][row] = 'O';
          }
      }
  }

    }

