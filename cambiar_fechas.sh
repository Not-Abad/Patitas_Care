#!/bin/bash
# Fechas límite en segundos (Unix Timestamp UTC-6)
ORIG_START=1776699300   # 2026-04-20 12:15:00
ORIG_SPAN=4584435      # Duración original del proyecto (~53 días)

TARGET_START=1791656100 # 2026-10-10 12:15:00
TARGET_SPAN=1032435    # Nuevo rango objetivo (~12 días hasta el 22/10/2026)

# Obtiene la fecha de autoría original del commit actual
ORIG_DATE=$(git log -1 --format="%ad" --date=iso)
ORIG_TS=$(date -d "$ORIG_DATE" +%s 2>/dev/null)

if [ -n "$ORIG_TS" ]; then
    OFFSET=$((ORIG_TS - ORIG_START))
    if [ $OFFSET -lt 0 ]; then OFFSET=0; fi

    # Interpolación lineal para reubicar la fecha entre Oct 10 y Oct 22
    NEW_TS=$((TARGET_START + (OFFSET * TARGET_SPAN / ORIG_SPAN)))
    NEW_DATE=$(date -d "@$NEW_TS" +"%Y-%m-%d %H:%M:%S -0600")

    # Aplica la nueva fecha al Autor y al Committer conservando el autor original y mensaje
    GIT_COMMITTER_DATE="$NEW_DATE" git commit --amend --date="$NEW_DATE" --no-edit
fi
