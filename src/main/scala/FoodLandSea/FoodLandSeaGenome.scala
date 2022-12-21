package FoodLandSea

import FoodLandSea.FoodLandSeaOrganism.Instruction
import model.generics.*


trait FoodLandSeaGenome extends Genome:
  val geneSequence: List[FoodLandSeaSurroundings] = FoodLandSeaSurroundings.allEnvirons

class FoodLandSeaOrganism(chromosomes: Map[FoodLandSeaSurroundings, Instruction]) extends FoodLandSeaGenome

object FoodLandSeaOrganism {
  enum Instruction:
    case Move(direction: FoodLandSeaSurroundings.Direction)
    case TryEat, DoNothing // TODO: Add Random
}