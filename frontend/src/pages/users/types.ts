export type UserResponse = {
    users: User[]
    pagination: Pagination
}

export type User = {
    id?: number
    firstName: string
    lastName: string
    email: string
    phoneNumber: string
    role: string
}

export type Pagination = {
    page: number
    size: number
    totalElements: number
    totalPages: number
}
