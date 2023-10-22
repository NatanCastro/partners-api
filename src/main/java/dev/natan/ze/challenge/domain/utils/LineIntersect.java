package dev.natan.ze.challenge.domain.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LineIntersect {
  public Boolean doIntersect(Line line1, Line line2) {
    double denominator = this.calculateDenominator(line1, line2);

    if (denominator == 0.0) {  // Lines are parallel
      return false;
    }
    double t = this.calculateT(line1, line2, denominator);
    double u = this.calculateU(line1, line2, denominator);

    return t >= 0.0 && t <= 1.0 && u >= 0.0 && u <= 1.0;
  }

  private Double calculateDenominator(Line line1, Line line2) {
    return (line2.end.getY() - line2.start.getY()) * (line1.end.getX() - line1.start.getX()) -
            (line2.end.getX() - line2.start.getX()) * (line1.end.getY() - line1.start.getY());
  }

  private Double calculateT(Line line1, Line line2, Double denominator) {
    return ((line2.end.getX() - line2.start.getX()) * (line1.start.getY() - line2.start.getY()) -
            (line2.end.getY() - line2.start.getY()) * (line1.start.getX() - line2.start.getX())) / denominator;
  }

  private Double calculateU(Line line1, Line line2, Double denominator) {
    return -((line1.end.getX() - line1.start.getX()) * (line1.start.getY() - line2.start.getY()) -
            (line1.end.getY() - line1.start.getY()) * (line1.start.getX() - line2.start.getX())) / denominator;
  }

  @Data
  @AllArgsConstructor
  public static class Point {
    double x;
    double y;
  }

  @Data
  @AllArgsConstructor
  public static class Line {
    private Point start;
    private Point end;
  }
}
