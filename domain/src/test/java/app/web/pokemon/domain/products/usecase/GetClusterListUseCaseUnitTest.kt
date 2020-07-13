package app.web.pokemon.domain.products.usecase

import app.web.pokemon.domain.extension.getSingleError
import app.web.pokemon.domain.extension.getSingleListSuccess
import app.web.pokemon.domain.extension.getSingleSuccess
import app.web.pokemon.domain.products.entity.ProductsFactory
import app.web.pokemon.domain.products.repository.ProductsRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetClusterListUseCaseUnitTest {

    private lateinit var getClusterListUseCase: GetClusterListUseCase

    @Mock
    private lateinit var productsRepository: ProductsRepository

    @Before
    fun setUp() {
        getClusterListUseCase = GetClusterListUseCase(productsRepository)
    }

    @Test
    fun `invoke should return list of clusters`() {
        whenever(productsRepository.getBeersById(""))
            .doReturn(getSingleListSuccess(ProductsFactory.providesBeer()))

        val testObserver = getClusterListUseCase(Unit).testAwait()

        testObserver.assertGeneralsSuccess {
            it.clusters.isNotEmpty()
        }
    }

    @Test
    fun `invoke should not return list of clusters in case of an error`() {
        whenever(productsRepository.getClusters())
            .doReturn(getSingleError())

        val testObserver = getClusterListUseCase(Unit).testAwait()

        testObserver.assertGeneralsError()
    }

}