export interface AccessTokenResponse {
    access_token: string,
    expires_in: number,
    scope: string,
    jti: string
}