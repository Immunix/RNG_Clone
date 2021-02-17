package com.example.rngclone.data

data class Results(
    private val rngResults: RngResults,
    private val diceResults: DiceResults,
    private val lottoResults: LottoResults,
    private val coinResults: CoinResults
) {
    data class RngResults(private val numbers: Int, private val sum: Int?)

    data class DiceResults(private val rolls: Int, private val sum: Int)

    data class LottoResults(private val numbers: Int)

    data class CoinResults(
        private val sides: String,
        private val numberHeads: Int,
        private val numberTails: Int
    )
}