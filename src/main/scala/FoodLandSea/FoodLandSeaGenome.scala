package FoodLandSea

import FoodLandSea.FoodLandSeaOrganism.Instruction
import model.generics.*


trait FoodLandSeaGenome extends Genome:
  val geneSequence: List[FoodLandSeaEnvironment] = FoodLandSeaEnvironment.allEnvirons

class FoodLandSeaOrganism(chromosomes: Map[FoodLandSeaEnvironment, Instruction]) extends FoodLandSeaGenome

object FoodLandSeaOrganism {
  enum Instruction:
    case Move(direction: FoodLandSeaEnvironment.Direction)
    case TryEat, DoNothing // TODO: Add Random
}