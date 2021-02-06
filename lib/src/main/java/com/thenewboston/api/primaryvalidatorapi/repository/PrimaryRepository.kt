package com.thenewboston.api.primaryvalidatorapi.repository

import com.thenewboston.api.primaryvalidatorapi.datasource.PrimaryDataSource
import com.thenewboston.common.http.Outcome
import com.thenewboston.data.dto.common.response.ValidatorList
import com.thenewboston.data.dto.primaryvalidatorapi.accountdto.AccountBalance
import com.thenewboston.data.dto.primaryvalidatorapi.accountdto.AccountBalanceLock
import com.thenewboston.data.dto.primaryvalidatorapi.accountdto.AccountFromValidatorList
import com.thenewboston.data.dto.primaryvalidatorapi.bankdto.BankFromValidator
import com.thenewboston.data.dto.primaryvalidatorapi.bankdto.BankFromValidatorList
import com.thenewboston.data.dto.primaryvalidatorapi.configdto.PrimaryValidatorDetails
import com.thenewboston.utils.PaginationOptions
import io.ktor.util.*
import javax.inject.Inject

@KtorExperimentalAPI
class PrimaryRepository @Inject constructor(private val dataSource: PrimaryDataSource) {

    suspend fun bankFromValidator(nodeIdentifier: String): Outcome<BankFromValidator> =
        dataSource.fetchBankFromValidator(nodeIdentifier)

    suspend fun banksFromValidator(offset: Int, limit: Int): Outcome<BankFromValidatorList> =
        dataSource.fetchBanksFromValidator(PaginationOptions(offset, limit))

    suspend fun primaryValidatorDetails(): Outcome<PrimaryValidatorDetails> =
        dataSource.fetchPrimaryValidatorDetails()

    suspend fun accountsFromValidator(offset: Int, limit: Int): Outcome<AccountFromValidatorList> =
        dataSource.fetchAccountsFromValidator(PaginationOptions(offset, limit))

    suspend fun accountBalance(accountNumber: String): Outcome<AccountBalance> =
        dataSource.fetchAccountBalance(accountNumber)

    suspend fun accountBalanceLock(accountNumber: String): Outcome<AccountBalanceLock> =
        dataSource.fetchAccountBalanceLock(accountNumber)

    suspend fun validators(offset: Int, limit: Int): Outcome<ValidatorList> =
        dataSource.fetchValidators(PaginationOptions(offset, limit))

    suspend fun validator(nodeIdentifier: String) = dataSource.fetchValidator(nodeIdentifier)

    suspend fun confirmationBlocks(blockIdentifier: String) = dataSource.fetchConfirmationBlocks(blockIdentifier)
}