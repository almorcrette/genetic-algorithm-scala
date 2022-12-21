package model.generics

trait Genome:
  val geneSequence: List[SensoryInputs]

trait Organism extends Genome


trait SensoryInputs


trait Simulation

case class TrialOutcome(organism: Genome, score: Int)

class Life(organism: Genome, trailOutcomes: List[TrialOutcome])

class Generation(lives: List[Life])




