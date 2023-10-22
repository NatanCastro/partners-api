package dev.natan.ze.challenge.domain.entity;

import dev.natan.ze.challenge.domain.utils.LineIntersect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverageArea {
  private String type;
  private Object coordinates;

  public Boolean isPointInside(Double lat, Double lng) {
    int lineIntersectCount = 0;

    LineIntersect lineIntersect = new LineIntersect();
    List<List<List<List<Double>>>> multiPolygon = (List<List<List<List<Double>>>>) coordinates;

    LineIntersect.Point rayCastingStart = new LineIntersect.Point(lat, lng);
    LineIntersect.Point rayCastingEnd = new LineIntersect.Point(Integer.MAX_VALUE, lng);
    LineIntersect.Line rayCastingLine = new LineIntersect.Line(rayCastingStart, rayCastingEnd);

    for (List<List<List<Double>>> polygon : multiPolygon) {
      for (List<List<Double>> ring : polygon) {
        for (int i = 0; i < ring.size() - 1; i++) {
          LineIntersect.Point start = new LineIntersect.Point(ring.get(i).get(0), ring.get(i).get(1));
          LineIntersect.Point end = new LineIntersect.Point(ring.get(i + 1).get(0), ring.get(i + 1).get(1));
          LineIntersect.Line line = new LineIntersect.Line(start, end);

          if (lineIntersect.doIntersect(line, rayCastingLine))
            ++lineIntersectCount;
        }
      }
    }

    System.out.println(lineIntersectCount);
    return lineIntersectCount % 2 == 1;
  }
}
