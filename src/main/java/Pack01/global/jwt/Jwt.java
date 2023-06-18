package Pack01.global.jwt;

import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import io.jsonwebtoken.*;

import java.util.Date;

public class Jwt {
    final String secretKey = "PoscoDX Spring Project";
    public String createJWT(Member member) {
        long expirationMillis = 1000 * 60L * 2L;


        long currentTimeMillis = System.currentTimeMillis();
        Date now = new Date(currentTimeMillis);

        Claims claims = Jwts.claims()
                .setSubject("access_token")
                .setIssuedAt(now)
                .setExpiration(new Date(currentTimeMillis + expirationMillis));

        claims.put("id", member.getMember_id());
        claims.put("role", member.getMember_role());
        claims.put("name", member.getMember_name());

        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();

        return jwt;
    }

    public Claims getJwtContents(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(jwt).getBody();

        return claims;
    }

    public boolean checkClaim(String jwt){
        try{
            Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .parseClaimsJws(jwt).getBody();

            return true;
        }catch(ExpiredJwtException e){
            System.out.println("Token expired");
            return false;
        }catch(JwtException e){
            System.out.println("Invalid token");
            return false;
        }
    }
}
