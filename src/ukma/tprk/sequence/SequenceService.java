package ukma.tprk.sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ukma.tprk.generator.SequenceGenerator;

public class SequenceService {

    private List<Double> sequence;
    private List<Double> points;

    private final double epselon;

    public SequenceService(List<SequencePartConfig> params, double epselon) {
        this.epselon = epselon;
        sequence = new ArrayList<Double>();
        Collections.sort(params);

        for (SequencePartConfig param : params) {
            SequenceGenerator sequenceGenerator = new SequenceGenerator(param.getInput(), param.getStart(),
                    param.getEnd());
            List<Double> currentSequence = sequenceGenerator.getSequence();

            sequence.addAll(currentSequence);
        }

        setPoints(SequenceAnalyzer.getPoints(sequence, epselon));
    }

    public SequenceService(List<SequencePartConfig> params, int equalValue, double epselon) {
        this.epselon = epselon;
        sequence = new ArrayList<Double>();
        Collections.sort(params);

        for (SequencePartConfig param : params) {
            SequenceGenerator sequenceGenerator = new SequenceGenerator(param.getInput(), param.getStart(),
                    param.getEnd());
            List<Double> currentSequence = sequenceGenerator.getSequence();

            sequence.addAll(currentSequence);
        }

        sequence = SequenceAnalyzer.generateProbabilitySequence(sequence, equalValue);
        setPoints(SequenceAnalyzer.getPoints(sequence, epselon));
    }

    public List<Double> getSequence() {
        return sequence;
    }

    public List<Double> getPoints() {
        return points;
    }

    private void setPoints(List<Double> points) {
        this.points = points;
    }

    public double getEpselon() {
        return epselon;
    }

}