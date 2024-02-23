package com.example.actividadfinalaccesodatos_adriansabinoperez

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.HiddenHttpMethodFilter

/**
 * Configuración de la aplicación web.
 */
@Configuration
class WebConfig {

    /**
     * Configura y devuelve un filtro HiddenHttpMethodFilter.
     *
     * Este filtro permite el uso de métodos HTTP como PUT o DELETE a través de un campo "_method" en formularios HTML.
     *
     * @return Instancia de HiddenHttpMethodFilter configurada.
     */
    @Bean
    fun hiddenHttpMethodFilter(): HiddenHttpMethodFilter {
        return HiddenHttpMethodFilter()
    }
}
