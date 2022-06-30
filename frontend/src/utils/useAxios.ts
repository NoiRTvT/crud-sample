import {makeUseAxios, Options} from 'axios-hooks'
import axios from 'axios'

const useAxios = makeUseAxios({
    axios: axios.create({}),
    defaultOptions: {
        autoCancel: true,
        ssr: false,
        useCache: false
    }
})

export const useGet = <T>(url: string, options?: Options, params?: any) => {
    return useAxios<T>(
        {
            url,
            method: 'GET',
            params
        },
        options
    )
}

export const usePut = <R, B>(url: string) => {
    return useAxios<R, B>(
        {
            url,
            method: 'PUT'
        },
        {manual: true}
    )
}

export const usePost = <R, B>(url: string) => {
    return useAxios<R, B>(
        {
            url,
            method: 'POST'
        },
        {manual: true}
    )
}
export const useDelete = <T>(url: string) => {
    return useAxios<T>(
        {
            url,
            method: 'DELETE'
        },
        {manual: true}
    )
}
